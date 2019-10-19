package com.xds.recharge.dto;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetAccessTokenDto {

    private JSONObject accessTokenResult;
    /**
     * -1未关注微信公众号 0-绑定手机号页面，1-答题页面，2-结果页面
     */
    private int page;


    private String result;



}
