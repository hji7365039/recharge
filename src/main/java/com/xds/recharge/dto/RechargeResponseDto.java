package com.xds.recharge.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 充值返回类
 */

@Data
@ToString
public class RechargeResponseDto {
    /**
     * 00
     */
    private String code;
    /**
     * 交易成功
     */
    private String desc;
    /**
     *success
     */
    private String status;
    /**
     * 交易总金额
     */
    private String amount;
    /**
     * 合作方交易时间(也可以是订单创建时间，格式为：yyyyMMddHHmmss)
     */
    private String areaCode;
    /**
     * 充值平台方流水号
     */
    private String bizOrderId;
    /**
     * 运营商类别
     */
    private String carrierType;

    /**
     * 商品面值，单位为厘
     */
    private String itemFacePrice;

    /**
     * 商品编号
     */
    private String itemId;
    /**
     * 平台上商品对应的名称
     */
    private String itemName;
    /**
     * 商品单价，单位厘
     */
    private String price;
    /**
     * 合作方（代理方）流水号
     */
    private String serialno;
}
