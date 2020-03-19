package com.zcd.dao;

import com.zcd.model.Shop;

import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2020/2/20 20:25
 */
public interface ShopMapper {
    List<Shop> index(String recommend);

    List<Shop> login(String name);

}
