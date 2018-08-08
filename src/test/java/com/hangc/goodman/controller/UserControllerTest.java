package com.hangc.goodman.controller;

import com.hangc.goodman.entity.UserBean;
import com.hangc.goodman.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Test
    public void delUser() {
        System.out.println("delUser");
        List<UserBean> userBeanList = userService.queryAll(0, 100);
        for (UserBean bean : userBeanList) {
            System.out.println("delUser:" + bean.toString());
        }

    }

    @Test
    public void addUser() {
        MockHttpServletRequest req=new MockHttpServletRequest();
        UserBean user = new UserBean();
        user.setName("cheng525");
        user.setPhone("138009000");
        System.out.println("addUser:"+userController.addUser(user));
    }
}