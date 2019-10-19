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
 * topic
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */

@Data
@ToString
public class Topic {
    /** 版本号 */
    private static final long serialVersionUID = 7794908771944564289L;

    /** id */
    private String id;

    /** top */
    private String top;

    /** 内容 */
    private String centent;

    /** 排序，1-10 */
    private Integer orderby;

    /** 0-单选，1-多选 */
    private Integer choice;

    /** 状态0-启用，1-禁用 */
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

    /**
     * 答案列表
     */
    List<Answer> answerList;


}