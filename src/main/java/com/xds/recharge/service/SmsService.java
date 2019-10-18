package com.xds.recharge.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

/**
 * 短信服务
 * by 黄金浩
 */
public interface SmsService {

    SendSmsResponse sendSms (String mobileNo, String centent);
}
