package com.zcd.controller;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcd.model.Visitor;
import com.zcd.service.VisitorService;
import com.zcd.util.JsonUtil;
import org.codehaus.jackson.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/visitor")
public class VisitorRestController {
     @Autowired
    private VisitorService visitorService;

      //此produces属性用于解决乱码 produces = "application/json;charset=utf-8"
     @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login(
            @RequestParam(required = false,defaultValue = "") String username,
            // @RequestParam(required = false,defaultValue = "1") Visitor visitor,
            @RequestParam(required = false,defaultValue = "2") int id,
            @RequestParam(required = false,defaultValue = "") String password) throws IOException {

         //ObjectMapper mapper = new ObjectMapper();

         Map<Visitor,Visitor> map =new HashMap<>();
         id = 3;


         final Visitor visitorById = visitorService.getVisitorByid(id);

         return new ObjectMapper().writeValueAsString(visitorById);
    }




    /*
    * 这里采用com.fasterxml.jackson.databind 这里的包,
    * 其他版本的包不知道是不带格式化日期功能还是怎么着
    *
    *      <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.8</version>
    *
    * */
    @RequestMapping(value = "/date",produces = "application/json;charset=utf-8")
    public String dateTest() throws com.fasterxml.jackson.core.JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
         //日期类型默认返回的是时间戳,即毫秒数,这里关闭时间戳功能
         mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

         //自定义日期格式化类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        mapper.setDateFormat(sdf);

        Date date = new Date();

         return mapper.writeValueAsString(date);
    }


    /*
    * 封装工具包
    * */
    @RequestMapping(value = "/util",produces = "application/json;charset=utf-8")
    public String useUtil() {
        return JsonUtil.getJson(new Date());
    }


}
