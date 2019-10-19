package com.xds.recharge.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RechargeNotifyDto {
    private String userId;
    private String bizId;
    private String ejId;
    private String downstreamSerialno;
    private String voucher;
    private String voucherType;
    private String status;
    private String sign;


}
