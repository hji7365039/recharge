package com.xds.recharge.service;
import	java.awt.Desktop.Action;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.RechargeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


public class WxTest extends RechargeApplicationTests {

    @Autowired
    private WxService wxService;

    @Test
    public void testGetAccessToken(){
        JSONObject result = wxService.getAccessToken("081OMor914NnKO1B5jr91RWjr91OMorh");
        System.out.println(result);
        System.out.println(result.getString("access_token"));
    }

    @Autowired
    private CheckCodeService checkCodeService;

    @Test
    public void testGetCode(){
        checkCodeService.saveCheckCode("15606527728");
    }
}
