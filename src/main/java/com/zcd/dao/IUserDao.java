package com.zcd.dao;

import com.zcd.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IUserDao {
    int deleteByPrimaryKey(Integer id);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    User selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(User record);
    
    void updateByVerifyCode(String VerifyCode);

    User selectByName(String username);


    // 不止一个参数的记得加个@param注解,别问,问就是不知道,加上去就对了,不会有人说你写错了的
    User login(@Param("username") String username, @Param("password") String password, @Param("VerifyCode") String VerifyCode);
}