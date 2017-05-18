package com.zx.service;

import com.zx.model.Evaluate;

import java.util.Map;

/**
 * Created by Xin on 2017/5/11.
 */
public interface EvaluateService {
    Integer addEvaluate(Evaluate evaluate);
    Evaluate findEvaluateByDoid(Integer doid);
    Evaluate findEvaluateByEid(Integer eid);
    Integer updateEvaluate(Evaluate evaluate);
    Map<String,Object> findAllEvaluateBack(Integer currentPage, Integer lineSize, String keyWord) throws Exception;
    Integer deleteEvaluate(Evaluate evaluate);
}
