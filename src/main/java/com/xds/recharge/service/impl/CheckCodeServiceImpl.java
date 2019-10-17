package com.xds.recharge.service.impl;

import com.xds.recharge.service.CheckCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class CheckCodeServiceImpl  implements CheckCodeService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean saveCheckCode(String mobileNo) {
        try{
            String code=createCheckCode();
            System.out.println("code="+code);
            redisTemplate.opsForValue().set(mobileNo,code);
            System.out.println("放入redis成功");
            return true;
        }catch (Exception e){
            System.out.println("存储redis异常"+mobileNo);
            return false;
        }
    }


    @Override
    public boolean checkCode(String code, String mobileNo) {
        String redisCode=  getCheckCode(mobileNo);
        if(redisCode==null||redisCode.equals("")||!redisCode.equals(code)){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 创建code
     * @return
     */
    private String createCheckCode() {
        int code=(int)((Math.random()*9+1)*100000);
        return code+"";
    }

    /**
     * 从redis获取验证码
     * @param mobileNo
     * @return
     */
    private String getCheckCode(String mobileNo) {
        return redisTemplate.opsForValue().get(mobileNo);
    }
}
