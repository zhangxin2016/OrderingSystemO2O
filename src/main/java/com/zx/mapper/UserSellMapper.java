package com.zx.mapper;

import com.zx.model.UserSell;
import com.zx.model.UserSellExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSellMapper {
    int countByExample(UserSellExample example);

    int deleteByExample(UserSellExample example);

    int deleteByPrimaryKey(Integer usid);

    int insert(UserSell record);

    int insertSelective(UserSell record);

    List<UserSell> selectByExample(UserSellExample example);

    UserSell selectByPrimaryKey(Integer usid);

    int updateByExampleSelective(@Param("record") UserSell record, @Param("example") UserSellExample example);

    int updateByExample(@Param("record") UserSell record, @Param("example") UserSellExample example);

    int updateByPrimaryKeySelective(UserSell record);

    int updateByPrimaryKey(UserSell record);
    /**
     * @title :getUserByNameAndPass
     * @description :登录验证
     */
    UserSell getUserByNameAndPass(UserSell user);

    /**
     * @title :checkRegister
     * @description :注册验证
     */
    UserSell checkRegister(String name);

    List<UserSell> findAllUserSellBack(String keyWord)throws Exception ;

    UserSell findStoresByUserSell(Integer usid);

}