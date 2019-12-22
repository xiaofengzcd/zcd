package com.javen.controller;

import com.javen.model.Visitor;
import com.javen.service.VisitorService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/visitor")
public class VisitorRestController {
     @Autowired
    private VisitorService visitorService;
     @RequestMapping("/login")
    public Visitor login(
            @RequestParam(required = false,defaultValue = "") String username,
         //   @RequestParam(required = false,defaultValue = "1") Visitor visitor,
            @RequestParam(required = false,defaultValue = "1") int id,
            @RequestParam(required = false,defaultValue = "") String password){

         Map<Visitor,Visitor> map =new HashMap<>();


         final Visitor visitorByid = visitorService.getVisitorByid(id);

         return null;
    }


}
