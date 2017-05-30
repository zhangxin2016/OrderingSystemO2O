package com.zx.service;

import com.zx.model.UserBuy;
import com.zx.util.Page;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * @title :getUserByNameAndPass
     * @description :用户登录验证实现类
     */
    UserBuy getUserByNameAndPass(UserBuy user);

    /**
     * @title :register
     * @description :接口方法实现类，进行用户信息录入
     */
    int register(UserBuy user);

    /**
     * @title :checkRegister
     * @description :验证用户是否存在，防止重名
     */
    UserBuy checkRegister(String name);

    UserBuy checkRegisterByUidcard(String uidcard);

    /**
     * @title :updateDetail
     * @description :更新用户基本信息（用户名、性别、生日）
     */
    int updateDetail(UserBuy user);

    /**
     * @title :updatePhone
     * @description :更新绑定手机
     */
    int updatePhone(UserBuy user);

    /**
     * @title :updateEmail
     * @description :更新邮箱
     */
    int updateEmail(UserBuy uer);

    /**
     * @title :updatePass
     * @description :更新密码
     */
    public int updatePass(UserBuy user);

    //修改个人信息
    public int updateUser(UserBuy ue);
    int updateUserBuy(UserBuy userBuy);
    UserBuy selectByPrimaryKey(Integer uid);

    List<Integer> selectByFindStrs(String username);

    /**
     * @类名： UserService
     * @方法名： getCounts
     * @描述：   分页
     * @返回类型： Integer
     */
    Integer getCounts();



    List<UserBuy> getAll(Page page);

    List<UserBuy> findByid(int uid,Page page);

    /**
     * @类名： UserService
     * @方法名： findByName
     * @描述：   根据用户名查询
     * @返回类型： List<UserBuy>
     */
    List<UserBuy> findByName(String username);

    Map<String,Object> findAllUserBuyBack(Integer currentPage, Integer lineSize, String keyWord) throws Exception;

    Integer deleteUserBuyByAdmin(Integer uid) throws Exception;
}
