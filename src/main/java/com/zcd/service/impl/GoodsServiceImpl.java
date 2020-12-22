package com.zcd.service.impl;

import com.zcd.dao.GoodsMapper;
import com.zcd.dao.ShopMapper;
import com.zcd.model.Goods;
import com.zcd.model.Shop;
import com.zcd.model.User;
import com.zcd.service.GoodsService;
import com.zcd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2020/2/20 20:29
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public List<Goods> index(String keyword) {
        return goodsMapper.index(keyword);
    }

}
