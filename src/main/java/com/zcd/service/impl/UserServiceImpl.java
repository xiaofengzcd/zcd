package com.zcd.service.impl;

import javax.annotation.Resource;


import com.zcd.dao.UserDao;
import com.zcd.service.UserService;
import org.springframework.stereotype.Service;

import com.zcd.model.User;

import java.io.InputStream;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    
    public User getUserById(int userId) {
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByName(String username) {
        return this.userDao.selectByName(username);
    }

    @Override
    public void updateByVerifyCode(String VerifyCode) {
        userDao.updateByVerifyCode(VerifyCode);
    }

    @Override
    public User login(String username, String password,String VerifyCode) {
        return userDao.login( username,  password, VerifyCode);
    }

    @Override
    public void insert(User user/*String username, String password, int age, String VerifyCode*/) {
        userDao.insert(user /*username,password,age,VerifyCode*/);
    }

}  
