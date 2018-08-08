package com.hangc.goodman.dao;


import com.hangc.goodman.entity.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hangc
 * @date 17/9/20
 */
public interface UserDao {
    int insertUser(UserBean user);

    UserBean queryByName(@Param("name") String name);

    UserBean queryByPhone(@Param("phone") String phone);

    List<UserBean> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int deleteUser(@Param("userid") int id);

    int updateUser(UserBean user);
}
