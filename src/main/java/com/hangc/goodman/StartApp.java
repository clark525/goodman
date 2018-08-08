package com.hangc.goodman;

import com.hangc.goodman.entity.UserBean;
import com.hangc.goodman.service.UserService;
import com.hangc.goodman.util.ConfUtil;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StartApp {

    private static Logger logger = Logger.getLogger(StartApp.class);


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, IOException {
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        String signClazzName = ConfUtil.get("sign.util.class.name");
        logger.info("signClazzName:" + signClazzName);

        Class<?> signClazz = Class.forName(signClazzName);
        Object obj = signClazz.newInstance();


        MethodType signMethodType = MethodType.methodType(String.class, String.class);

        MethodHandle sign = MethodHandles.lookup().findVirtual(signClazz, "sign", signMethodType);

        MethodType verifyMethodType = MethodType.methodType(Boolean.class, String.class, String.class);
        MethodHandle verify = MethodHandles.lookup().findVirtual(signClazz, "verify", verifyMethodType);

        String signStr = "I am OK!";
        String signValue = "";
        try {
            signValue = (String) sign.invoke(obj, signStr);
            logger.info("signValue:" + signValue);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        try {
            Boolean verifyResult = (boolean) verify.invoke(obj, signStr, signValue);
            logger.info("verifyResult:" + verifyResult);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        UserBean userBean = new UserBean();
        signClazz = userBean.getClass();

        //获取构造方法
        Constructor[] constructors = signClazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            logger.info("构造方法：" + constructor);
        }
        //获取成员变量
        Field[] fieldArray = signClazz.getDeclaredFields();
        for (Field field : fieldArray) {
            logger.info("成员变量：" + field);
        }

        Method[] methods = signClazz.getDeclaredMethods();
        for (Method method : methods) {
            logger.info("成员方法：" + method);
        }


        Jsoup.connect("http://music.163.com/playlist?id=317113395")
                .header("Referer", "http://music.163.com/")
                .header("Host", "music.163.com").get().select("ul[class=f-hide] a")
                .stream().map(w -> w.text() + "-->" + w.attr("href"))
                .forEach(System.out::println);


    }

    public void print() {
        
    }
}
