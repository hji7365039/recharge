package com.xds.recharge.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetAccessTokenDto {

    private String accessTokenResult;
    /**
     * 0-绑定手机号页面，1-答题页面，2-结果页面
     */
    private int page;


    private String result;



}
