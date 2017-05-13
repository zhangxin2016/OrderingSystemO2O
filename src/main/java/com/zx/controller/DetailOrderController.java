package com.zx.controller;

import com.zx.model.Detailorder;
import com.zx.model.Order;
import com.zx.model.UserBuy;
import com.zx.service.DetailOrderService;
import com.zx.service.OrderService;
import com.zx.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/5/2.
 */
@Controller
public class DetailOrderController {
    @Autowired
    private DetailOrderService detailOrderService;
    @Autowired
    private OrderService ordersService;
    //前台根据用户获取所有订单明细
    //分页功能
    //未实现，分页功能失败
    @RequestMapping("/findDetailOrderListByFront")
    public ModelAndView findDetailOrderListByFront(@RequestParam(value="currentPage",defaultValue="1") Integer currentPage,
                                                   @RequestParam(value="lineSize",defaultValue="5") Integer lineSize ,
                                                   HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView mv=new ModelAndView("front/user/userorderlist");
        UserBuy user = (UserBuy) session.getAttribute("user");
        List<Order> orderList = ordersService.orderByUser(user.getUid());
        Map<String,Object> map=null;
        List<Detailorder> detailorderList = new ArrayList<>();
        List<Detailorder> detailorderListByOid = new ArrayList<>();
        for(Order order:orderList){
            detailorderListByOid = detailOrderService.findDetailOrderList1(order.getOid());
            for(Detailorder detailorder:detailorderListByOid){
                detailorderList.add(detailorder);
            }
        }
        map = this.detailOrderService.findDetailOrderList(currentPage, lineSize, detailorderList);
        System.out.println("map====="+map);
        System.out.println("map.get(detailorderList)"+map.get("detailorderList"));
        mv.addObject("detailorderList", map.get("detailorderList"));
        /**
         * 下面的分页参数一定要传过去,不然没法使用分页插件
         */
        mv.addObject("pageInfo", map.get("pageInfo"));
        System.out.printf("map.get(pageInfo)"+map.get("pageInfo"));
        mv.addObject("lineSizes", new int[]{5,10,15,20,25,30});
        return mv  ;
    }

    @RequestMapping("/listOrderDetailByFront")
    public String listOrderDetailByFront(Map<String,Object> map ,HttpServletRequest request,HttpSession session) throws Exception {
        UserBuy user = (UserBuy) session.getAttribute("user");
        List<Order> orderList = ordersService.orderByUser(user.getUid());
        List<Detailorder> detailorderList = new ArrayList<>();
        List<Detailorder> detailorderListByOid = new ArrayList<>();
        for(Order order:orderList){
            detailorderListByOid = detailOrderService.findDetailOrderList1(order.getOid());
            for(Detailorder detailorder:detailorderListByOid){
                detailorderList.add(detailorder);
            }
        }
        request.setAttribute("detailorderList",detailorderList);
        return "front/user/userorderlist";
    }

    @RequestMapping("/userSellSendFood")
    public String userSellSendFood(Map<String,Object> map,Integer doid,HttpServletRequest request,HttpSession session) throws Exception {
        //Integer doid = Integer.valueOf(request.getParameter("doid"));
        Detailorder detailorder = detailOrderService.findDetailOrderByDoid(doid);
        Detailorder detailorder1 = new Detailorder();
        detailorder1.setDoid(doid);
        detailorder1.setAdid(detailorder.getAdid());
        detailorder1.setDonum(detailorder.getDonum());
        detailorder1.setDopri(detailorder.getDopri());
        detailorder1.setDostatus(1);
        detailorder1.setFid(detailorder.getFid());
        detailorder1.setOid(detailorder.getOid());
        detailorder1.setDodate(detailorder.getDodate());
        detailorder1.setDodelete(detailorder.getDodelete());
        detailorder1.setDomessage(detailorder.getDomessage());
        detailOrderService.updateDetailOrder(detailorder1);
        return "redirect:getStoresBySellId.html";
    }

    @RequestMapping("/userBuySureFood")
    public String userBuySureFood(Map<String,Object> map ,Integer doid,HttpServletRequest request,HttpSession session) throws Exception {
        //Integer doid = Integer.valueOf(request.getParameter("doid"));
        Detailorder detailorder = detailOrderService.findDetailOrderByDoid(doid);
        Detailorder detailorder1 = new Detailorder();
        detailorder1.setDoid(doid);
        detailorder1.setAdid(detailorder.getAdid());
        detailorder1.setDonum(detailorder.getDonum());
        detailorder1.setDopri(detailorder.getDopri());
        detailorder1.setDostatus(2);
        detailorder1.setFid(detailorder.getFid());
        detailorder1.setOid(detailorder.getOid());
        detailorder1.setDodate(detailorder.getDodate());
        detailorder1.setDodelete(detailorder.getDodelete());
        detailorder1.setDomessage(detailorder.getDomessage());
        detailOrderService.updateDetailOrder(detailorder1);
        return "redirect:listOrderDetailByFront.html";
    }

}