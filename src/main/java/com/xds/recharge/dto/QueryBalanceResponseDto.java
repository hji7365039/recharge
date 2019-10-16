package com.xds.recharge.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryBalanceResponseDto {

    private String status;
    private String desc;
    private String code;
    private String balance;

}
