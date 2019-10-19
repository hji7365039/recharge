package com.xds.recharge.dto;

import lombok.Data;

@Data
public class HandInAnswerResponseDto {

    /**
     *0- 未中奖，1-中奖
     */
    private int state;
    private String centent;
}
