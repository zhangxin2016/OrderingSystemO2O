package com.zx.service;

import com.zx.model.Detailorder;

import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/4/26.
 */
public interface DetailOrderService {
    Integer addDetailorder(Detailorder detailorder);

    Integer countByNoSend(Integer oid);

    Integer countByNoSigh(Integer oid);

    Integer countByNoEvaluate(Integer oid);

    //前台根据用户显示所有订单明细
    Map<String,Object> findDetailOrderList(Integer currentPage, Integer lineSize, List<Detailorder> detailorderList)throws Exception ;

    List<Detailorder> findDetailOrderList1(Integer oid) throws Exception;
}
