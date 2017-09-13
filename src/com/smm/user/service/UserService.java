package com.smm.user.service;

import com.smm.user.dao.UserDao;
import com.smm.user.pojo.User;

/**
 * Created by TaroChen on 2017/8/4.
 */
public class UserService {

    // 注入Dao
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(User user){

       return userDao.login(user);

    }
}
