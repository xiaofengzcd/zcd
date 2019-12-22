package com.javen.service.impl;

import com.javen.dao.VisitorMapper;
import com.javen.model.Visitor;
import com.javen.service.VisitorService;
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
