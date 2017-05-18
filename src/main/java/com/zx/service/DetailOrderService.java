package com.zx.service;

import com.zx.model.Detailorder;
import com.zx.util.Page;

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
    Detailorder findDetailOrderByDoid(Integer doid);
    Integer updateDetailOrder(Detailorder detailorder);
    List<Detailorder> findDetailListByFid(Integer fid);

    List<Detailorder> getAllDetailOrderBack(Page page);

    Integer getAllDetailOrderCounts();

    Detailorder finddetailOrderListByDoid(Integer doid);
}
