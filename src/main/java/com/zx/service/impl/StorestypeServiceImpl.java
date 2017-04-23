package com.zx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.mapper.StorestypeMapper;
import com.zx.model.Storestype;
import com.zx.model.StorestypeExample;
import com.zx.service.StorestypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/3/27.
 */

@Service
public class StorestypeServiceImpl implements StorestypeService {
    @Autowired
    private StorestypeMapper storestypeMapper;

    @Transactional
    public Map<String,Object> findAll(Integer currentPage, Integer lineSize,
                                      String keyWord) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>()   ;    //map集合保存分页信息和数据
        PageHelper.startPage(currentPage, lineSize)           ;     //设置分页参数
        if("".equals(keyWord) || keyWord==null){    //组织关键词
            keyWord="%"+keyWord+"%"  ;
        }else{
            keyWord="%"+keyWord+"%" ;
        }
        List<Storestype> storestypes=this.storestypeMapper.findAll(keyWord) ;   //模糊查询
        PageInfo<Storestype> pageInfo=new PageInfo<Storestype>(storestypes) ; //获取分页信息
        map.put("storestypes", storestypes)   ;
        map.put("pageInfo", pageInfo)   ;
        return map;
    }
    @Override
    public int insert(Storestype storestype) {
        return storestypeMapper.insert(storestype);
    }

    @Override
    public int deleteByPrimaryKey(Integer aid) {
        return storestypeMapper.deleteByPrimaryKey(aid);
    }

    @Override
    public int updateByPrimaryKey(Storestype storestype) {
        return storestypeMapper.updateByPrimaryKey(storestype);
    }

    @Override
    public Storestype selectByPrimaryKey(Integer id) {
        return storestypeMapper.selectByPrimaryKey(id);
    }
}
