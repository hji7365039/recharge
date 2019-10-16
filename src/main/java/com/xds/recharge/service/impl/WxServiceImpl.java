package com.xds.recharge.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WxServiceImpl implements WxService {

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Value("${wx.grant_type}")
    private String grant_type;

    @Value("${wx.getAccessTokenUrl}")
    private String getAccessTokenUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JSONObject getAccessToken(String code) {
        String url = getAccessTokenUrl + "?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=" + grant_type;
        JSONObject result = JSONObject.parseObject(restTemplate.getForObject(url, String.class));
        return result;
    }
}
