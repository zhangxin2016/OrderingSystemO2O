package com.zx.service;

import com.zx.model.Order;

import java.util.List;

/**
 * Created by Xin on 2017/4/26.
 */
public interface OrderService {
    //增加订单
    Integer addOrders(Order orders);
    //修改订单信息
    void updateOrders(Order orders)throws Exception;
    //根据uid获取订单列表
    List<Order> orderByUser(Integer uid);
}
