package com.zcd.service.impl;

import com.zcd.dao.GirlDao;
import com.zcd.pojo.Girl;
import com.zcd.service.GirlService;
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

    @Override
    public Girl login(String name) {
        return this.girlDao.login(name);
    }


}
