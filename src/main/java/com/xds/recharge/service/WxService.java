package com.xds.recharge.service;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.dto.CheckUserDto;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信接口
 */
public interface WxService {

    JSONObject getAccessToken(String code,HttpServletRequest request);


    CheckUserDto checkUser(String openid);
}
