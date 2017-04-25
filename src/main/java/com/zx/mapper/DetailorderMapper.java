package com.zx.mapper;

import com.zx.model.Detailorder;
import com.zx.model.DetailorderExample;
import java.util.List;
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
}