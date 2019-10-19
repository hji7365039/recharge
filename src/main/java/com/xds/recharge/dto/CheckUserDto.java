package com.xds.recharge.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CheckUserDto {

    /**
     * -1未关注微信公众号、结果页面 0-绑定手机号页面，1-答题页面
     */
    private int page;
    private String centent;
}
