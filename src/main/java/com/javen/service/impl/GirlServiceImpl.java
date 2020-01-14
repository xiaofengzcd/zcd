package com.javen.service.impl;

import com.javen.dao.GirlDao;
import com.javen.pojo.Girl;
import com.javen.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zcd
 * @description:
 * @create 2020/1/10 16:51
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlDao girlDao;


    public Girl getGirlById(int id) {
        return this.girlDao.selectById(id);
    }



}
