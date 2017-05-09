package com.zx.service.impl;

import com.zx.mapper.OrderMapper;
import com.zx.model.Order;
import com.zx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xin on 2017/4/26.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper ordersMapper;
    @Override
    public Integer addOrders(Order orders) {
        return ordersMapper.insert(orders);
    }

    @Override
    public void updateOrders(Order orders) throws Exception {
        ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public List<Order> orderByUser(Integer uid) {
        return ordersMapper.orderByUser(uid);
    }
}
