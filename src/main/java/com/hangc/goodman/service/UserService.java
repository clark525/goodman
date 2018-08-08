package com.hangc.goodman.service;


import com.hangc.goodman.entity.UserBean;

import java.util.List;

/**
 * Created by clark on 17/9/20.
 */
public interface UserService {
    int insertUser(UserBean user);
    UserBean queryUserByPhone(String Phone);
    List<UserBean> queryAll(int offset, int limit);
    int deleteUser(int id);
}
