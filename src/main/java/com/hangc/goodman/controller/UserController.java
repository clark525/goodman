package com.hangc.goodman.controller;


import com.hangc.goodman.entity.UserBean;
import com.hangc.goodman.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hangc
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/del", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html; charset=utf-8")
    public /*Map<String, String> */ String delUser(Long id) {
        Map<String, String> map = new HashMap<>();
        System.out.println("del---" + id);
        logger.info("ssm-core|UserController|删除user:id=" + id);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html; charset=utf-8")
    public/* Map<String, String>*/ String addUser(UserBean user) {
        Map<String, String> map = null;
        try {
            map = new HashMap<>();
            System.out.println("add---" + user);
            logger.info("ssm-core|UserController|addUser:user=" + user);
            int resultCode= userService.insertUser(user);
            map.put("resultCode",resultCode+"");
            map.put("resultDesc","success");
//            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("resultDesc","failed");
        }
        return map.get("resultDesc");
    }


}
