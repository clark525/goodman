package com.hangc.goodman.util;

import org.apache.log4j.Logger;
import org.springframework.util.Base64Utils;

public class SignUtil {

    private static Logger logger = Logger.getLogger(SignUtil.class);

    private String signType;

    public SignUtil() {
        logger.info("SignUtil无参构造方法");
    }

    private SignUtil(String signType) {
        this.signType = signType;
        logger.info("SignUtil单参数参构造方法");
    }

    public String sign(String signStr) {
        String signValue = "";
        try {
            signValue = Base64Utils.encodeToString(signStr.getBytes("utf-8"));
            logger.info(String.format("signStr:%s,signValue:%s", signStr, signValue));
        } catch (Exception e) {
            logger.error("签名失败", e);
        }
        return signValue;
    }

    public Boolean verify(String signStr, String signValue) {
        boolean verifyResult = false;
        if (signStr.equals(new String(Base64Utils.decodeFromString(signValue)))) {
            verifyResult = true;
            logger.info(String.format("signStr:%s,signValue:%s,verifyResult:%s", signStr, signValue, verifyResult));
        }
        return verifyResult;
    }
}
