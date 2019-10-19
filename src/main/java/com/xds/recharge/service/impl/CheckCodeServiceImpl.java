package com.xds.recharge.service.impl;

import com.xds.recharge.dao.WxDao;
import com.xds.recharge.dao.WxUserDao;
import com.xds.recharge.dto.WxUserDto;
import com.xds.recharge.model.WxUser;
import com.xds.recharge.service.CheckCodeService;
import com.xds.recharge.service.SmsService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class CheckCodeServiceImpl implements CheckCodeService {

    public static final Logger logger =  LoggerFactory.getLogger(CheckCodeServiceImpl.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private SmsService smsService;

    @Autowired
    private WxDao wxDao;

    @Autowired
    WxUserDao wxUserDao;

    @Override
    public boolean saveCheckCode(String mobileNo) {
        try {
            String code = createCheckCode();
            System.out.println("code=" + code);
            redisTemplate.opsForValue().set(mobileNo, code, 60L * 1, TimeUnit.SECONDS);
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
    public boolean checkCode(String code, String mobileNo, String openid) {
        String redisCode = getCheckCode(mobileNo);
        if (StringUtils.isBlank(redisCode) || !redisCode.equals(code)) {
            return false;
        } else {
            //删除验证码
            deleteCheckCode(mobileNo);

            WxUser wxUser = new WxUser();
            wxUser.setOpenId(openid);
            wxUser=wxUserDao.findWxUserByCondition(wxUser);
            if(wxUser!=null){
                if(wxUser.getMobileNo().equals(mobileNo)){
                    return true;
                }else{
                    WxUserDto wxUserDto = new WxUserDto();
                    wxUserDto.setMobileNo(mobileNo);
                    wxUserDto.setOpenId(openid);
                    // 绑定手机号码和openId
                    wxDao.updateByOpenId(wxUserDto);
                    return true;
                }
            }

            WxUserDto wxUser1 = new WxUserDto();
            wxUser1.setId(UUID.randomUUID().toString());
            wxUser1.setOpenId(openid);
            wxUser1.setMobileNo(mobileNo);
            wxDao.insertWxUser(wxUser1);
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


    /**
     * 删除验证码
     * @param mobileNo
     */
    private void deleteCheckCode(String mobileNo){
        redisTemplate.delete(mobileNo);
        System.out.println("删除后的验证码:"+getCheckCode(mobileNo));
    }
}
