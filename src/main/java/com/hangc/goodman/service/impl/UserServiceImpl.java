package com.hangc.goodman.service.impl;

import com.hangc.goodman.dao.UserDao;
import com.hangc.goodman.entity.UserBean;
import com.hangc.goodman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clark on 17/9/20.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int insertUser(UserBean user) {
        return userDao.insertUser(user);
    }

    @Override
    public UserBean queryUserByPhone(String Phone) {
        return userDao.queryByPhone(Phone);
    }


    @Override
    public List<UserBean> queryAll(int offset, int limit) {
        return userDao.queryAll(offset, limit);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
