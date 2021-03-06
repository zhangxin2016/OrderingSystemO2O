package com.zx.mapper;

import com.zx.chart.DetailChartSal;
import com.zx.model.Detailorder;
import com.zx.model.DetailorderExample;
import java.util.List;

import com.zx.model.OrderChart;
import com.zx.util.Page;
import org.apache.ibatis.annotations.Param;

public interface DetailorderMapper {
    int countByExample(DetailorderExample example);

    int deleteByExample(DetailorderExample example);

    int deleteByPrimaryKey(Integer doid);

    int insert(Detailorder record);

    int insertSelective(Detailorder record);

    List<Detailorder> selectByExample(DetailorderExample example);

    Detailorder selectByPrimaryKey(Integer doid);

    int updateByExampleSelective(@Param("record") Detailorder record, @Param("example") DetailorderExample example);

    int updateByExample(@Param("record") Detailorder record, @Param("example") DetailorderExample example);

    int updateByPrimaryKeySelective(Detailorder record);

    int updateByPrimaryKey(Detailorder record);

    int countByNoSend(Integer oid);

    int countByNoSigh(Integer oid);

    int countByNoEvaluate(Integer oid);

    List<Detailorder> selectdetailOrderList(Integer oid);

    List<Detailorder> selectdetailOrderListByFid(Integer fid);

    List<Detailorder> selectdetailOrderListFrontIndex();

    List<Detailorder> getAllDetailOrderBack(Page page);

    Integer getAllDetailOrderCounts();

    Detailorder selectdetailOrderListByDoid(Integer doid);

    List<OrderChart> chartByDate();

    List<DetailChartSal> DetailOrderChart();
}