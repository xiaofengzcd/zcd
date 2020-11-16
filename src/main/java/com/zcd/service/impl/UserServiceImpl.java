package com.zcd.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.zcd.dao.IUserDao;
import com.zcd.model.User;
import com.zcd.service.IUserService;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;
    
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

}  
