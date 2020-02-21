package com.zcd.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.zcd.dao.IUserDao;
import com.zcd.model.User;
import com.zcd.service.IUserService;


@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;
    
    public User getUserById(int userId) {
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);
    }
    
}  
