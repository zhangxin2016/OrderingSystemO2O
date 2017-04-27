package com.zx.service;

import com.zx.model.Order;

/**
 * Created by Xin on 2017/4/26.
 */
public interface OrderService {
    //增加订单
    Integer addOrders(Order orders);
    //修改订单信息
    void updateOrders(Order orders)throws Exception;
}
