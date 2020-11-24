package com.zcd.service;

import com.zcd.model.User;

import java.util.List;


public interface IUserService {
   User getUserById(int userId);

    User getUserByName(String username);

    void updateByVerifyCode(String VerifyCode);

    User login(String username, String password, String VerifyCode);
}  