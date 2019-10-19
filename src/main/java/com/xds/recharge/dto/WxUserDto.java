package com.xds.recharge.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WxUserDto extends BaseDto {

    private String openId;

    private String mobileNo;

}
