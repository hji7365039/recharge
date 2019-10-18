package com.xds.recharge.service.impl;


import com.xds.recharge.dto.QueryBalanceResponseDto;
import com.xds.recharge.service.RechargeService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RechargeServiceImpl implements RechargeService {

    private static String url="http://39.108.59.67:8160/unicomAync/queryBalance.do";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public QueryBalanceResponseDto queryBalance(){
        String sign="990"+"df41bbb9ee213bdb0e46c2021e572fb392a2a2ce0df5e168422c8a486d62ee29";
        sign = DigestUtils.md5Hex(sign.getBytes());
        String requestUrl=url+"?userId=990&sign="+sign;
        QueryBalanceResponseDto responseDto=restTemplate.getForObject(requestUrl,QueryBalanceResponseDto.class);
        return responseDto;
    }

}
