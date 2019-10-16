package com.xds.recharge.service;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.RechargeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WxTest extends RechargeApplicationTests {

    @Autowired
    private WxService wxService;

    @Test
    public void testGetAccessToken(){
        JSONObject result = wxService.getAccessToken("081OMor914NnKO1B5jr91RWjr91OMorh");
        System.out.println(result);
        System.out.println(result.getString("access_token"));
    }
}
