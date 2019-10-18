package com.xds.recharge.service;

import com.xds.recharge.RechargeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RechargeTest extends RechargeApplicationTests {

    @Autowired
    RechargeService rechargeService;

    @Autowired
    SmsService smsService;

    @Test
    public void queryBalanceTest(){
        rechargeService.queryBalance();
    }


    @Test
    public void sendSms(){
        smsService.sendSms("18072811971","{\"code\":\"1233\"}");
    }
}
