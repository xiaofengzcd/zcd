package com.zcd.controller;

import com.zcd.service.IUserService;
import com.zcd.util.JsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcd
 * @description:
 * @create 2020/3/20 23:40
 */
@RestController
@RequestMapping("/user2")
public class UserController2 {

    @RequestMapping("/test")
    public String test(){
        return JsonUtil.getJson("CESHI");
    }



    @RequestMapping("/login")
    public String login( String username ,  String password, Model model){

        username = "root";
        password = "123456";
        //获取当前用户
        final Subject subject = SecurityUtils.getSubject();

        //封装用户数据
        final UsernamePasswordToken token = new UsernamePasswordToken(username,password);


        try{
            subject.login(token); // 执行登陆方法,若果没问题即代表ok
            return JsonUtil.getJson("成功");
        }catch (UnknownAccountException e){
            return JsonUtil.getJson("失败");
        }


    }


}
