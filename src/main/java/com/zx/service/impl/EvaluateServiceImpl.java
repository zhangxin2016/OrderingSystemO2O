package com.zx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.mapper.EvaluateMapper;
import com.zx.model.Evaluate;
import com.zx.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Evaluate findEvaluateByEid(Integer eid) {
        return evaluateMapper.selectByPrimaryKey(eid);
    }

    @Override
    public Integer updateEvaluate(Evaluate evaluate) {
        return evaluateMapper.updateByPrimaryKeySelective(evaluate);
    }

    @Override
    public Map<String, Object> findAllEvaluateBack(Integer currentPage, Integer lineSize, String keyWord) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();    //map集合保存分页信息和数据
        PageHelper.startPage(currentPage, lineSize);     //设置分页参数
        if("".equals(keyWord) || keyWord==null){    //组织关键词
            keyWord="%"+keyWord+"%";
        }else{
            keyWord="%"+keyWord+"%";
        }
        List<Evaluate> evaluateListBack=this.evaluateMapper.findAllEvaluateBack(keyWord);   //模糊查询
        System.out.println("evaluateListBack======"+evaluateListBack);
        PageInfo<Evaluate> pageInfo=new PageInfo<Evaluate>(evaluateListBack); //获取分页信息
        map.put("evaluateListBack", evaluateListBack);
        map.put("pageInfo", pageInfo);
        return map;
    }

    @Override
    public Integer deleteEvaluate(Evaluate evaluate) {
        return evaluateMapper.updateByPrimaryKeySelective(evaluate);
    }
}
