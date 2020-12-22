package com.zcd.service;

import com.zcd.model.Goods;
import com.zcd.model.Shop;
import com.zcd.model.User;

import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2020/12/17 15:32
 */
public interface GoodsService {

    public List<Goods> index(String keyword);

}
