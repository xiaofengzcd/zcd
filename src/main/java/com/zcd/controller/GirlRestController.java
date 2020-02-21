package com.zcd.controller;

import com.zcd.pojo.Girl;
import com.zcd.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcd
 * @description:
 * @create 2020/1/10 16:36
 */
@RestController
@RequestMapping("/girl")
public class GirlRestController {

    @Autowired
    private GirlService girlService;

    @RequestMapping("/test")
    public Girl test(int id){
       girlService.getGirlById(id);
       return girlService.getGirlById(id);
    }
}
