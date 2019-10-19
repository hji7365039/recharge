package com.xds.recharge.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 充值请求类
 */

@Data
@ToString
public class RechargeDto {
    /**
     * 合作方用户编号(充值平台方提供)
     */
    private String userId;
    /**
     * 话费面额，单位为厘  1元=1000厘
     */
    private String itemFacePrice;
    /**
     * 客户手机号，被充值号码
     */
    private String uid;
    /**
     * 合作方商户系统的流水号，全局唯一（不能重复使用）
     */
    private String serialno;
    /**
     * 合作方交易时间(也可以是订单创建时间，格式为：yyyyMMddHHmmss)
     */
    private String dtCreate;

    /**
     * 签名(MD5)sign=MD5(amt+dtCreate+ext1+ext2+itemFacePrice+serialno+uid+userId+privatekey);
     */
    private String sign;
}
