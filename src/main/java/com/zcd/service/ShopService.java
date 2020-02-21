package com.zcd.service;

import com.zcd.model.Shop;
import com.zcd.model.Visitor;

import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2020/2/20 20:29
 */
public interface ShopService {
    public List<Shop> index(String recommend);
}
