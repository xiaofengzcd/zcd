package com.zcd.service;

import com.zcd.model.User;


public interface IUserService {
    public User getUserById(int userId);

    public User getUserByName(String username);
}  