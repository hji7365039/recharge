package com.xds.recharge.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryBalanceDto {

    private String userId;
    private String sign;

}
