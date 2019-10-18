package com.xds.recharge.service.impl;

import com.xds.recharge.common.SysLog;
import com.xds.recharge.service.CheckCodeService;
import com.xds.recharge.service.SmsService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class CheckCodeServiceImpl implements CheckCodeService {

    public static final Logger logger =  LoggerFactory.getLogger(CheckCodeServiceImpl.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private SmsService smsService;

    @Override
    public boolean saveCheckCode(String mobileNo) {
        try {
            String code = createCheckCode();
            System.out.println("code=" + code);
            redisTemplate.opsForValue().set(mobileNo, code);
            System.out.println("放入redis成功");
            String smsCode = "{\"code\":" + code + "}";
            smsService.sendSms(mobileNo, smsCode);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }


    @Override
    public boolean checkCode(String code, String mobileNo) {
        String redisCode = getCheckCode(mobileNo);
        if (StringUtils.isBlank(redisCode) || !redisCode.equals(code)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 创建code
     *
     * @return
     */
    private String createCheckCode() {
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        return code + "";
    }

    /**
     * 从redis获取验证码
     *
     * @param mobileNo
     * @return
     */
    private String getCheckCode(String mobileNo) {
        return redisTemplate.opsForValue().get(mobileNo);
    }
}
