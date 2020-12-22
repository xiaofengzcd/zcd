package com.zcd.controller;

import com.zcd.dto.BaseResult;
import com.zcd.model.Goods;
import com.zcd.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2020/12/17 15:23
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {

     @Autowired
     private GoodsService goodsService;
    /**
     * @author zcd
     * @description: 简单的搜索
     * @create 2020/12/17
     */
    @RequestMapping(value = "/index")
    public BaseResult index(@RequestParam(defaultValue = "") String keyword){
        // BaseResult baseResult = null;
        List<Goods> goods = goodsService.index(keyword);

        return  BaseResult.success(goods);
    }
}
