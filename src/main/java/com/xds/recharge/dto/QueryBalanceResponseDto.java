package com.xds.recharge.dto;

public class QueryBalanceResponseDto {

    private String status;
    private String desc;
    private String code;
    private String balance;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "QueryBalanceResponseDto{" +
                "status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                ", code='" + code + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
