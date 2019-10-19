/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:5.8.8
 */

package com.xds.recharge.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * answer
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
@Data
@ToString
public class Answer {
    /** 版本号 */
    private static final long serialVersionUID = 8424045478843852934L;

    /** id */
    private String id;

    /** topicId */
    private String topicId;

    /** centent */
    private String centent;

    /** 排序，1，2，3，4，5，6 */
    private Integer orderby;

    /** score */
    private Integer score;

    /** 0-启用，1-禁用 */
    private Integer state;

    /** createTime */
    private Date createTime;

    /** creator */
    private String creator;

    /** updateTime */
    private Date updateTime;

    /** updator */
    private String updator;

    /** remark */
    private String remark;


}