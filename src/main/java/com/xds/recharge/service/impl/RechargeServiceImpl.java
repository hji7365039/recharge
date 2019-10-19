package com.xds.recharge.service.impl;


import com.xds.recharge.dto.QueryBalanceResponseDto;
import com.xds.recharge.dto.RechargeDto;
import com.xds.recharge.dto.RechargeResponseDto;
import com.xds.recharge.service.RechargeService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Value("${channel.key}")
    private  String key;

    @Value("${channel.account}")
    private  String account;

    @Value("${channel.queryBalanceURL}")
    private  String queryBalanceURL;

    @Value("${channel.rechargeURL}")
    private  String rechargeURL;

    @Autowired
    private RestTemplate restTemplate;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Override
    public QueryBalanceResponseDto queryBalance(){
        String sign=account+key;
        sign = DigestUtils.md5Hex(sign.getBytes());
        String requestUrl=queryBalanceURL+"?userId="+account+"&sign="+sign;
        QueryBalanceResponseDto responseDto=restTemplate.getForObject(requestUrl,QueryBalanceResponseDto.class);
        return responseDto;
    }


    @Override
    public RechargeResponseDto recharge(String mobileNo,String faceValue,String serialNo){
        RechargeDto rechargeDto=new RechargeDto();

        rechargeDto.setUserId(account);
        rechargeDto.setItemFacePrice(faceValue);
        rechargeDto.setUid(mobileNo);
        rechargeDto.setSerialno(serialNo);
        String dtCreate=sdf.format(new Date());
        rechargeDto.setDtCreate(dtCreate);
        String sign=dtCreate+faceValue+serialNo+mobileNo+account+key;
        //System.out.println(sign);
        sign = DigestUtils.md5Hex(sign.getBytes());
        //System.out.println(sign);
        rechargeDto.setSign(sign);
        String requestUrl=rechargeURL+"?userId="+account
                +"&itemFacePrice="+faceValue
                +"&uid="+mobileNo
                +"&serialno="+serialNo
                +"&dtCreate="+dtCreate
                +"&sign="+sign;
        //System.out.println(requestUrl);
        RechargeResponseDto responseDto=restTemplate.getForObject(requestUrl,RechargeResponseDto.class);
        return responseDto;
    }

}
