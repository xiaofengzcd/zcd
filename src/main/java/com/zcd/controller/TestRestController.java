package com.zcd.controller;

import com.zcd.model.Girl;
import com.zcd.service.GirlService;
import com.zcd.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * /**
 *
 * @author zcd
 * @description: TODO
 * @date 2019/6/2014:27
 */
@RestController
@RequestMapping("/abc")
public class TestRestController {
    @Autowired
    TestService testService;

    @RequestMapping("/zcd")
    public List<String> Test(
            @RequestParam(required = false, defaultValue = "") final String requestParam,
            HttpServletRequest request, ModelMap modelMap,
            Model model) {
        List<String> stringList = testService.list01();
        List<String> stringList02 = testService.list02();
        model.addAttribute("list", stringList);
        Object list = modelMap.put("list", stringList);
        ModelMap list1 = modelMap.addAttribute("list", stringList);
        System.out.println("************************************");
        System.out.println(list);
        System.out.println(list1);
        request.getCookies();
        //System.out.println(request.toString());
        request.setAttribute("list02", stringList02);
        //System.out.println(model);
        //System.out.println(request);
        return stringList02;
    }

    @RequestMapping("/zcx")
    public String Test02() {
        testService.Put();
        return "test";
    }

    @Autowired
    private GirlService girlService;

    @RequestMapping("/test")
    public Girl test(
            @RequestParam int id ,Model model) {
        id = 2;

        return this.girlService.getGirlById(id);
    }
}
