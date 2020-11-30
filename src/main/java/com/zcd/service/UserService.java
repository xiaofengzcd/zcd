package com.zcd.service;

import com.zcd.dto.BaseResult;
import com.zcd.model.User;
import org.apache.poi.ss.formula.functions.T;

import java.io.InputStream;
import java.util.List;


public interface UserService {
   User getUserById(int userId);

    User getUserByName(String username);

    void updateByVerifyCode(String VerifyCode);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 保存信息
     * @param
     * @return
     */
    BaseResult save(User user);

 /**
  * 根据 ID 获取信息
  *
  * @param id
  * @return
  */

  User getById(Long id);



 /**
  * 更新信息
  * @param
  */
 void update(User user);




    User login(String username, String password, String VerifyCode);

    void insert(User user /*String username, String password, int age, String VerifyCode*/);
}  