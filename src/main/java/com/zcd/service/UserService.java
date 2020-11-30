package com.zcd.service;

import com.zcd.model.User;

import java.io.InputStream;
import java.util.List;


public interface UserService {
   User getUserById(int userId);

    User getUserByName(String username);

    void updateByVerifyCode(String VerifyCode);

    User login(String username, String password, String VerifyCode);

    void insert(User user /*String username, String password, int age, String VerifyCode*/);
}  