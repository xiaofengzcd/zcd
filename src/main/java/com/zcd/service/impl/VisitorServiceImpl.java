package com.zcd.service.impl;

import com.zcd.dao.VisitorMapper;
import com.zcd.model.Visitor;
import com.zcd.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("VisitorService")
public class VisitorServiceImpl implements VisitorService {
     @Autowired
    private VisitorMapper visitorMapper;

    @Override
    public Visitor getVisitorByid(int id) {

        return visitorMapper.selectByid(id);
    }
}
