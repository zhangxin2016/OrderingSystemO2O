package com.zx.mapper;

import com.zx.model.UserBuy;
import com.zx.model.UserBuyExample;
import java.util.List;

import com.zx.util.Page;
import org.apache.ibatis.annotations.Param;

public interface UserBuyMapper {
    int countByExample(UserBuyExample example);

    int deleteByExample(UserBuyExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(UserBuy record);

    int insertSelective(UserBuy record);

    List<UserBuy> selectByExample(UserBuyExample example);

    UserBuy selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") UserBuy record, @Param("example") UserBuyExample example);

    int updateByExample(@Param("record") UserBuy record, @Param("example") UserBuyExample example);

    int updateByPrimaryKeySelective(UserBuy record);

    int updateByPrimaryKey(UserBuy record);

    //分页
    Integer getCounts();
    List<UserBuy> getAll(Page page);
    List<UserBuy> findByid(int uid,Page page);

    //根据名称搜索用户信息
    List<UserBuy> findByName(String uname);

    List<UserBuy> findAllUserBuyBack(String keyWord)throws Exception ;

}