package com.javen.dao;

import com.javen.pojo.Girl;

/**
 * @author zcd
 * @description:
 * @create 2020/1/10 16:41
 */
public interface GirlDao {

    int insert(int id);

    Girl selectById(int id);

}
