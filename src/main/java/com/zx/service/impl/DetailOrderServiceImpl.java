package com.zx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.mapper.DetailorderMapper;
import com.zx.model.Detailorder;
import com.zx.model.Storestype;
import com.zx.service.DetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Integer countByNoSend(Integer oid) {
        return detailOrderMapper.countByNoSend(oid);
    }

    @Override
    public Integer countByNoSigh(Integer oid) {
        return detailOrderMapper.countByNoSigh(oid);
    }

    @Override
    public Integer countByNoEvaluate(Integer oid) {
        return detailOrderMapper.countByNoEvaluate(oid);
    }

    @Override
    public Map<String, Object> findDetailOrderList(Integer currentPage, Integer lineSize, List<Detailorder> detailorderList) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>()   ;    //map集合保存分页信息和数据
        PageHelper.startPage(currentPage, lineSize)           ;     //设置分页参数
        //List<Detailorder> detailorderList = this.detailOrderMapper.selectdetailOrderList(oid);
        PageInfo<Detailorder> pageInfo=new PageInfo<Detailorder>(detailorderList) ; //获取分页信息
        map.put("detailorderList", detailorderList)   ;
        map.put("pageInfo", pageInfo)   ;
        return map;
    }

    @Override
    public List<Detailorder> findDetailOrderList1(Integer oid) throws Exception {
        return detailOrderMapper.selectdetailOrderList(oid);
    }

    @Override
    public Detailorder findDetailOrderByDoid(Integer doid) {
        return detailOrderMapper.selectByPrimaryKey(doid);
    }

    @Override
    public Integer updateDetailOrder(Detailorder detailorder) {
        return detailOrderMapper.updateByPrimaryKeySelective(detailorder);
    }

    @Override
    public List<Detailorder> findDetailListByFid(Integer fid) {
        return detailOrderMapper.selectdetailOrderListByFid(fid);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        DetailOrderService detailOrderService = ac.getBean(DetailOrderService.class);
        //List<DetailOrderService> detailOrderServices = (List<DetailOrderService>) detailOrderService.findDetailOrderList(1,5,1);

        //System.out.println(detailOrderServices);
    }
}
