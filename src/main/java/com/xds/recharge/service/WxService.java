package com.xds.recharge.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信接口
 */
public interface WxService {

    JSONObject getAccessToken(String code);

}
