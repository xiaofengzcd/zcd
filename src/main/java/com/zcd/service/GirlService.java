package com.zcd.service;

import com.zcd.model.Girl;

/**
 * @author zcd
 * @description:
 * @create 2020/1/10 16:52
 */
public interface GirlService {
    public Girl getGirlById(int id);

    public Girl login(String name);
}
