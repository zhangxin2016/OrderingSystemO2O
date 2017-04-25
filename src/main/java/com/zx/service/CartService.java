package com.zx.service;

import com.zx.model.Cart;

import java.util.List;

/**
 * Created by Xin on 2017/4/23.
 */
public interface CartService {
    //添加购物车
    Integer addCart(Cart cart);
    //购物车列表（购物车中食物信息）
    List<Cart> findCartList(Cart cart) throws Exception;
    //根据食物ID获取购物车
    Cart findCartByFid(Integer fid)throws Exception;
    //修改购物车信息
    public void updateCart(Cart cart) throws Exception;
    //根据用户获取购物车数量
    Integer findCountCart(Integer uid);
    //根据用户获取购物车列表
    List<Cart> findCartListByUid(Integer uid) throws Exception;
    //根据购物车ID获取购物车信息
    Cart findCartByCid(Integer cid)throws Exception;

}
