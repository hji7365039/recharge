package com.xds.recharge.service;

import com.xds.recharge.RechargeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RechargeTest extends RechargeApplicationTests {

    @Autowired
    RechargeService rechargeService;

    @Test

    public void queryBalanceTest(){
        rechargeService.queryBalance();
    }
}
