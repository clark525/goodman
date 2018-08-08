package com.hangc.goodman;

import com.hangc.goodman.util.MyMD5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private static Map users = new HashMap();

    public static void main(String[] args) {
        String tag = "%s.%s(L:%d)";
        tag = String.format(tag, "ok","98",11);
        System.out.println(tag);

//        String pattern = "(dog)";
//        String content = "yes,i am ok.hah";
//        boolean isMatch = Pattern.matches(pattern, content);
//        System.out.println("结果：" + isMatch);
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        pattern = "^(2[5-9]|3[0])([0-9]{14,22})$";
        line="286720389985140962";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

        pattern = "\\({2}.*";
        String content = "(()";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("结果：" + isMatch);

        pattern = "^(2[5-9]|3[0])[0-9]{14,22}$";
        content="286720389985140962";
        isMatch = Pattern.matches(pattern, content);
        System.out.println("zfb：" + isMatch);

        String userName = "zyg";
        String password = "123";
        registerUser(userName, password);

        userName = "changong";
        password = "456";
        registerUser(userName, password);

        String loginUserId = "zyg";
        String pwd = "123";
        try {
            if (loginValid(loginUserId, pwd)) {
                System.out.println("欢迎登陆！！！");
            } else {
                System.out.println("口令错误，请重新输入！！！");
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 注册用户
     *
     * @param userName
     * @param password
     */
    public static void registerUser(String userName, String password) {
        String encryptedPwd = null;
        try {
            encryptedPwd = MyMD5Util.getEncryptedPwd(password);

            users.put(userName, encryptedPwd);

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 验证登陆
     *
     * @param userName
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static boolean loginValid(String userName, String password)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String pwdInDb = (String) users.get(userName);
        if (null != pwdInDb) { // 该用户存在
            return MyMD5Util.validPassword(password, pwdInDb);
        } else {
            System.out.println("不存在该用户！！！");
            return false;
        }
    }
}