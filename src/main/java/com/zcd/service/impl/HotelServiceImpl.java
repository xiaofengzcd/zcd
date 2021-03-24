package com.zcd.service.impl;


import com.zcd.dao.HotelDao;
import com.zcd.model.Hotel;
import com.zcd.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Hotel)表服务实现类
 *
 * @author makejava
 * @since 2021-01-21 11:12:48
 */
@Service("hotelService")
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Hotel queryById(Long id) {
        return this.hotelDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Hotel> queryAllByLimit(int offset, int limit) {
        return this.hotelDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    @Override
    public Hotel insert(Hotel hotel) {
        this.hotelDao.insert(hotel);
        return hotel;
    }

    /**
     * 修改数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    @Override
    public Hotel update(Hotel hotel) {
        this.hotelDao.update(hotel);
        return this.queryById(hotel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.hotelDao.deleteById(id) > 0;
    }
}