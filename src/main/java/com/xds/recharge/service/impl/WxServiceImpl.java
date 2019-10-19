package com.xds.recharge.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.dao.WxDao;
import com.xds.recharge.dto.WxUserDto;
import com.xds.recharge.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class WxServiceImpl implements WxService {

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Value("${wx.lang}")
    private String lang;

    @Value("${wx.grant_type}")
    private String grant_type;

    @Value("${wx.getAccessTokenUrl}")
    private String getAccessTokenUrl;

    @Value("${wx.getInfoUrl}")
    private String getInfoUrl;

    @Value("${wx.getTokenUrl}")
    private String getTokenUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WxDao wxDao;

    @Override
    public JSONObject getAccessToken(String code) {
        String url = getAccessTokenUrl + "?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=" + grant_type;
        JSONObject result = JSONObject.parseObject(restTemplate.getForObject(url, String.class));
        //判断openid是否存在我们库



        WxUserDto wxUser = new WxUserDto();
        wxUser.setId(UUID.randomUUID().toString());
        wxUser.setOpenId(result.getString("openid"));
        //wxDao.insertWxUser(wxUser);
        return result;
    }

    /**
     * 是否订阅
     * @return
     */
    private boolean isSubscribe(String openid){
        // 获取公众号token
        JSONObject result = JSONObject.parseObject(restTemplate.getForObject(getTokenUrl + "?grant_type=client_credential&appid=" + appid + "&secret=" + secret, String.class));
        String url = getInfoUrl + "?access_token=" + result.getString("access_token") + "&openid=" + openid + "&lang=" + lang;
        // 判断用户是否订阅
        result = JSONObject.parseObject(restTemplate.getForObject(url, String.class));
        return result.getInteger("subscribe") == 1 ? true :false;
    }

}
