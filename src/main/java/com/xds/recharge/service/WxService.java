package com.xds.recharge.service;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.dto.GetAccessTokenDto;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信接口
 */
public interface WxService {

    GetAccessTokenDto getAccessToken(String code, HttpServletRequest request);

}
