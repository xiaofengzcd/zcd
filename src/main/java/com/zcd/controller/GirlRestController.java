package com.zcd.controller;

import com.zcd.model.Girl;
import com.zcd.service.GirlService;
import com.zcd.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcd
 * @description: 此控制器错误代码一大推,已在其他地方解决,带Girl系列的暂时废弃 ~
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


    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login(String name){
       // name = "春哥";
        name = "zcx";

         Girl user = girlService.login(name);
         if(user == null){
             return JsonUtil.getJson("没有这个人");
         }else {
             return JsonUtil.getJson("登陆成功");
         }

    }



}
