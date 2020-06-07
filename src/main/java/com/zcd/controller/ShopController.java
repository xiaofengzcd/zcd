package com.zcd.controller;

import com.zcd.model.Shop;
import com.zcd.service.ShopService;
import com.zcd.service.VisitorService;
import com.zcd.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        recommend = "F";
         List<Shop> index = shopService.index(recommend);
        System.out.println(index);


        return JsonUtil.getJson(index);
    }


    /**
     * 我这里name 传英文字符串的话,是可以正常查询的,但如果name是中文的字符串,
     * 查出来的结果是个中括号,debug显示list里size为0,但是却不为null,
     * (如果是null的话,结果会是提示没这个人)
     * 初步得出结论,
     * 1.英文行,中文不行
     * 解决: url=jdbc:mysql://localhost:3306/zcx?useUnicode=true&characterEncoding
     * =utf8&characterSetResults=utf8
     * 原项目里的jdbc.properties文件里缺失关于字符编码的配置(坑逼啊!)
     *
     *
     * 2.即便查不到,这个list为空好像也不为null,暂且使用user.size() == 0作为判断条件代替
     *
     * list为空和null的区别,参考下面链接,这里虽然没查到东西,但list还是在的
     * 因此可用 isEmpty 或者 size等方法判断
     * @link https://www.cnblogs.com/linjiaxin/p/6104214.html
     *
     */
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login( @RequestParam String name){
        //实际情况应为对比,这里只做测试,仅查询
        name = "末世" ; //模拟用户名和密码登陆
        List<Shop> user = shopService.login(name);
        System.out.println(user);
        if (user.size() == 0){
            return JsonUtil.getJson("找不到这个人");
        }else{
            return JsonUtil.getJson("登陆成功");
        }



    }




}
