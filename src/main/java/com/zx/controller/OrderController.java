package com.zx.controller;

import com.alibaba.fastjson.JSON;
import com.zx.model.*;
import com.zx.service.*;
import com.zx.util.KafkaConsumer;
import com.zx.util.KafkaProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xin on 2017/4/26.
 */
@Controller
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService ordersService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private DetailOrderService detailOrderService;
    @Autowired
    private AddressService addressService;
    List<Order> ordersList = new ArrayList<Order>();

    @RequestMapping("/addFoodOrders")
    public String addFoodOrders(HttpSession session, String pays, HttpServletRequest request, Integer[] cartid, ModelMap modelMap) throws Exception {
        if (session.getAttribute("user")!=null) {
            int sumTotal = 0;
            int sumNum = 0;
            Order orders = new Order();
            String domessage = request.getParameter("domessage");
            Integer addressID = Integer.parseInt(request.getParameter("addressIn"));
            Address address = addressService.getadid(addressID);
            System.out.println("address=============" + addressID);
            UserBuy user = (UserBuy) session.getAttribute("user");
            orders.setUid(user.getUid());
            //orders.setOdate(new Date());
            ordersService.addOrders(orders);
            System.out.println("orders.getOid()=========>>>>>>>>======" + orders.getOid());
            for (int i = 0; i < cartid.length; i++) {
                Integer id = cartid[i];
                Cart cart1 = cartService.findCartByCid(id);
                //订单表的操作
                sumNum += cart1.getNum();
                sumTotal += cart1.getCtotal();
                Order orders1 = new Order();
                orders1.setOnum(sumNum);
                orders1.setOtatal(sumTotal);
                orders1.setOid(orders.getOid());
                orders1.setUid(user.getUid());
                orders1.setOdate(new Date());
                orders1.setOdelete(0);
                ordersList.add(orders1);
                //订单明细表增加
                Food foods = foodService.findFoodById(cart1.getFid());
                Detailorder detailorder = new Detailorder();
                detailorder.setAdid(addressID);
                detailorder.setDonum(cart1.getNum());
                detailorder.setDopri(cart1.getCtotal());
                detailorder.setDostatus(0);
                detailorder.setFid(cart1.getFid());
                detailorder.setOid(orders1.getOid());
                detailorder.setDodate(new Date());
                detailorder.setDomessage(domessage);
                detailOrderService.addDetailorder(detailorder);
            /*String msgDetailorder = JSON.toJSONString(detailorder);
            KafkaProduct kafkaProduct = new KafkaProduct();
            kafkaProduct.produceMsg(msgDetailorder,"kafkatopic");
            System.out.println("kafkatopic==============="+msgDetailorder);*/
                //进行商品表销售数量增加
                Food food = new Food();
                food.setFsalesvolume(foods.getFsalesvolume() + cart1.getNum());
                food.setFid(cart1.getFid());
                foodService.updateFood(cart1.getFid(), food);
                //删除购物车列表
                cartService.deleteCart(id);
            }

            //订单表保存
            for (Order orders2 : ordersList) {
                System.out.println(orders2);
                ordersService.updateOrders(orders2);
                System.out.println("----------------------" + orders2);
            }
       /* String msgOrder = JSON.toJSONString(ordersList.get(ordersList.size()-1));
        KafkaProduct kafkaProduct = new KafkaProduct();
        kafkaProduct.produceMsg(msgOrder,"ordertopic");;
        System.out.println("ordertopic==============="+msgOrder);*/
            modelMap.put("pays", pays);
            modelMap.put("addressOrderSuccess", address);
            return "front/food/paysuccess";
        }else{
            return "front/login";
        }
    }
    @RequestMapping("/orderByUserBuy")
    public void orderByUserBuy(HttpSession session, HttpServletRequest request, ModelMap modelMap) throws Exception {
        UserBuy user = (UserBuy) session.getAttribute("user");
        List<Order> orderListByUser = ordersService.orderByUser(user.getUid());
    }

}
