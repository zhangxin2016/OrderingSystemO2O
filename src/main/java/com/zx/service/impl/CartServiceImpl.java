package com.zx.service.impl;

import com.zx.mapper.CartMapper;
import com.zx.model.Cart;
import com.zx.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xin on 2017/4/23.
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public Integer addCart(Cart cart) {
        return cartMapper.insertSelective(cart);
    }

    @Override
    public List<Cart> findCartList(Cart cart) throws Exception {
        return cartMapper.findCartList(cart);
    }

    @Override
    public Cart findCartByFid(Integer fid) throws Exception {
        return cartMapper.findCartByFid(fid);
    }

    @Override
    public void updateCart(Cart cart) throws Exception {
        cartMapper.updateByPrimaryKeySelective(cart);
    }

    @Override
    public Integer findCountCart(Integer uid) {
        return cartMapper.countCart(uid);
    }
}
