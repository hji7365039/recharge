package com.xds.recharge.service.impl;


import com.xds.recharge.dto.QueryBalanceDto;
import com.xds.recharge.dto.QueryBalanceResponseDto;
import com.xds.recharge.service.RechargeService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RechargeServiceImpl implements RechargeService {


    private static String url="http://39.108.59.67:8160/unicomAync/queryBalance.do";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void queryBalance(){

        QueryBalanceDto dto= new QueryBalanceDto();
        dto.setUserId("453");
        String sign="453"+"df41bbb9ee213bdb0e46c2021e572fb392a2a2ce0df5e168422c8a486d62ee29";
        sign= MD5Encoder.encode(sign.getBytes());
        dto.setSign(sign);
        QueryBalanceResponseDto responseDto=restTemplate.postForObject(url,dto,QueryBalanceResponseDto.class);
        System.out.println(responseDto);
    }

}
