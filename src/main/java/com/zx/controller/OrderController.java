package com.zx.controller;

import com.zx.model.*;
import com.zx.service.CartService;
import com.zx.service.DetailOrderService;
import com.zx.service.FoodService;
import com.zx.service.OrderService;
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
    List<Order> ordersList = new ArrayList<Order>();
    int sumTotal=0;
    int sumNum=0;
    @RequestMapping("/addFoodOrders")
    public String addFoodOrders(HttpSession session, String pays, HttpServletRequest request, Integer[] cartid, ModelMap modelMap) throws Exception {
        Order orders = new Order();
        String domessage = request.getParameter("domessage");
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
            //--------------后续添加地址-------//
            detailorder.setAdid(1);
            detailorder.setDonum(cart1.getNum());
            detailorder.setDopri(cart1.getCtotal());
            detailorder.setDostatus(0);
            detailorder.setFid(cart1.getFid());
            detailorder.setOid(orders1.getOid());
            detailorder.setDodate(new Date());
            detailorder.setDomessage(domessage);
            detailOrderService.addDetailorder(detailorder);
            //进行商品表销售数量增加
            Food food = new Food();
            food.setFsalesvolume(foods.getFsalesvolume()+cart1.getNum());
            food.setFid(cart1.getFid());
            foodService.updateFood(cart1.getFid(),food);
            //删除购物车列表
            cartService.deleteCart(id);
        }
        //--------后续增加地址------//
        //订单表保存
        for(Order orders2:ordersList){
            System.out.println(orders2);
            ordersService.updateOrders(orders2);
            System.out.println("----------------------"+orders2);
        }
        modelMap.put("pays", pays);
        return "front/food/paysuccess";
    }
}
