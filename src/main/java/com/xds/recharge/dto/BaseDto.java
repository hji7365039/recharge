package com.xds.recharge.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class BaseDto implements Serializable {

    private String id;

    private Integer state;

    private Date createTime;

    private String creator;

    private Date updateTime;

    private String updator;

    private String remark;

}
