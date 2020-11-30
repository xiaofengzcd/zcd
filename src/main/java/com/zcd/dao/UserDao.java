package com.zcd.dao;

import com.zcd.model.User;
import org.apache.ibatis.annotations.Param;

import java.io.InputStream;
import java.util.List;


public interface UserDao {
    int deleteByPrimaryKey(Integer id);
    
    void insert(User user/*@Param("username")String username, @Param("password")String password, @Param("age")int age,
               @Param("VerifyCode")String VerifyCode*/);
    
    int insertSelective(User record);
    
    User selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(User record);
    
    void updateByVerifyCode(String VerifyCode);

    User selectByName(String username);


    // 不止一个参数的记得加个@param注解
    User login(@Param("username") String username, @Param("password") String password, @Param("VerifyCode") String VerifyCode);
}