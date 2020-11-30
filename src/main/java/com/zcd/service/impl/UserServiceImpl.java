package com.zcd.service.impl;

import javax.annotation.Resource;
import javax.faces.validator.BeanValidator;


import com.zcd.dao.UserDao;
import com.zcd.dto.BaseResult;
import com.zcd.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zcd.model.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.io.InputStream;
import java.util.Date;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    
    public User getUserById(int userId) {
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByName(String username) {
        return this.userDao.selectByName(username);
    }

    @Override
    public void updateByVerifyCode(String VerifyCode) {
        userDao.updateByVerifyCode(VerifyCode);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids) {
        userDao.deleteMulti(ids);
    }


    @Override
   @Transactional(readOnly = false)
    public BaseResult save(User user) {
        /*String validator = BeanValidator.validator(user);
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }

        // 通过验证
        else {*/
            user.setModifyDatetime(new Date());


            // 新增用户
            if (user.getId() == null) {
                // 密码需要加密处理
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                user.setCreateDatetime(new Date());
                userDao.insert(user);
            }

            // 编辑用户
            else {
                // 编辑用户时如果没有输入密码则沿用原来的密码
                if (StringUtils.isBlank(user.getPassword())) {
                    User olduser = getById(user.getId());
                    user.setPassword(olduser.getPassword());
                } else {
                    // 验证密码是否符合规范，密码长度介于 6 - 20 位之间
                    if (StringUtils.length(user.getPassword()) < 6 || StringUtils.length(user.getPassword()) > 20) {
                        return BaseResult.fail("密码长度必须介于 6 - 20 位之间");
                    }

                    // 设置密码加密
                    user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                }
                update(user);
            }

            return BaseResult.success("保存用户信息成功");
        /*}*/
    }


    /**
     * 根据 ID 获取信息
     *
     * @param id
     * @return
     */
    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }


    @Override
    public void update(User user) {
        userDao.update(user);
    }




    @Override
    public User login(String username, String password,String VerifyCode) {
        return userDao.login( username,  password, VerifyCode);
    }

    @Override
    public void insert(User user/*String username, String password, int age, String VerifyCode*/) {
        userDao.insert(user /*username,password,age,VerifyCode*/);
    }

}  
