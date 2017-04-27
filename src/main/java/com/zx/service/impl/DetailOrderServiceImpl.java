package com.zx.service.impl;

import com.zx.mapper.DetailorderMapper;
import com.zx.model.Detailorder;
import com.zx.service.DetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Xin on 2017/4/26.
 */
@Service
public class DetailOrderServiceImpl implements DetailOrderService {
    @Autowired
    private DetailorderMapper detailOrderMapper;
    @Override
    public Integer addDetailorder(Detailorder detailorder) {
        return detailOrderMapper.insertSelective(detailorder);
    }
}
