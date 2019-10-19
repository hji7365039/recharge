package com.xds.recharge.service;

public interface CheckCodeService {

    boolean saveCheckCode(String mobileNo);

    boolean checkCode(String code, String mobileNo, String openId);

}
