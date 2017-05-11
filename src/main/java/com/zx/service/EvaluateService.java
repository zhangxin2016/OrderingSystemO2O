package com.zx.service;

import com.zx.model.Evaluate;

/**
 * Created by Xin on 2017/5/11.
 */
public interface EvaluateService {
    Integer addEvaluate(Evaluate evaluate);
    Evaluate findEvaluateByDoid(Integer doid);
}
