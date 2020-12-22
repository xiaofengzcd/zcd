package com.zcd.dao;

import com.zcd.model.Goods;
import com.zcd.model.Shop;
import com.zcd.model.User;

import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2020/12/17 15:31
 */
public interface GoodsMapper {

    // List<Shop> index(String recommend);

    List<User> login(String user_name, String password);


    List<Goods> index (String keyword);
}
