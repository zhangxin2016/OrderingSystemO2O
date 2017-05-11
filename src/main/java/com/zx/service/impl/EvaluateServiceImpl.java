package com.zx.service.impl;

import com.zx.mapper.EvaluateMapper;
import com.zx.model.Evaluate;
import com.zx.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Xin on 2017/5/11.
 */
@Service
public class EvaluateServiceImpl implements EvaluateService{

    @Autowired
    private EvaluateMapper evaluateMapper;
    @Override
    public Integer addEvaluate(Evaluate evaluate) {
        return evaluateMapper.insertSelective(evaluate);
    }

    @Override
    public Evaluate findEvaluateByDoid(Integer doid) {
        return evaluateMapper.selectEvaluateByDoid(doid);
    }
}
