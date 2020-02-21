package com.zcd.controller;

import com.zcd.model.Shop;
import com.zcd.service.ShopService;
import com.zcd.service.VisitorService;
import com.zcd.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd
 * @description: 模拟王者农药商店~~~~
 * @create 2020/2/20 20:24
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/index",produces = "application/json;charset=utf-8")
    public String index(@RequestBody String recommend){
        recommend = "Y";
         List<Shop> index = shopService.index(recommend);

        return JsonUtil.getJson(index);
    }




}