package com.zx.controller;

import com.zx.model.Order;
import com.zx.model.UserBuy;
import com.zx.service.DetailOrderService;
import com.zx.service.FoodService;
import com.zx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Xin on 2017/5/2.
 */
@Controller
public class userCenterController {
    @Autowired
    private OrderService ordersService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private DetailOrderService detailOrderService;
    //用户中心首页显示订单状态数量
    @RequestMapping("/indexToUserCenter.html")
    public String indexToUserCenter(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserBuy user = (UserBuy) session.getAttribute("user");
        List<Order> orderList = ordersService.orderByUser(user.getUid());
        int countByNoSend = 0;
        int countByNoSigh = 0;
        int countByNoEvaluate = 0;
        for(Order order:orderList){
            countByNoSend = countByNoSend + detailOrderService.countByNoSend(order.getOid());
            countByNoSigh = countByNoSigh + detailOrderService.countByNoSigh(order.getOid());
            countByNoEvaluate = countByNoEvaluate + detailOrderService.countByNoEvaluate(order.getOid());
        }
        request.setAttribute("countByNoSend", countByNoSend);
        request.setAttribute("countByNoSigh", countByNoSigh);
        request.setAttribute("countByNoEvaluate", countByNoEvaluate);
        return "front/user/usercenter";
    }
    //用户中心显示我的订单（明细）
    @RequestMapping("myOrder")
    public String myOrder(HttpSession session, HttpServletRequest request, HttpServletResponse response){

        return "";
    }
}
