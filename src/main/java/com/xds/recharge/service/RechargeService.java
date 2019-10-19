package com.xds.recharge.service;

import com.xds.recharge.dto.QueryBalanceResponseDto;
import com.xds.recharge.dto.RechargeResponseDto;

public interface RechargeService {


    /**
     * 余额查询接口
     * @return
     */
    QueryBalanceResponseDto queryBalance();

    /**
     * 充值接口
     * @param mobileNo
     * @param faceValue
     * @param serialNo
     * @return
     */
    RechargeResponseDto recharge(String mobileNo, String faceValue, String serialNo);
}
