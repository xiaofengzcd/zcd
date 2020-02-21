package com.zcd.service.impl;

import com.zcd.dao.ShopMapper;
import com.zcd.model.Shop;
import com.zcd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2020/2/20 20:29
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;


    @Override
    public List<Shop> index(String recommend) {
        return shopMapper.index(recommend);
    }
}
