package com.zcd.controller;

import com.zcd.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * /**
 *
 * @author zcd
 * @description: TODO
 * @date 2019/6/21 14:39
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;
    
    @RequestMapping("/put")
    public String put(HttpServletRequest request) {
        
        return "result";
    }


    
}
