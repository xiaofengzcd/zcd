package com.zcd.controller;

import com.zcd.dto.BaseResult;
import com.zcd.model.Hotel;
import com.zcd.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Hotel)表控制层
 *
 * @author makejava
 * @since 2021-01-21 11:12:50
 */
@RestController
@RequestMapping("hotel")
public class HotelController {
    /**
     * 服务对象
     */
    @Autowired
    private HotelService hotelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("one")
    public BaseResult selectOne(Long id) {
        return BaseResult.success(null,this.hotelService.queryById(id)) ;
    }

}