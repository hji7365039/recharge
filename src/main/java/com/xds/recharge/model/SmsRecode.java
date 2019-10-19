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

import java.util.Date;

/**
 * sms_recode
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
public class SmsRecode {
    /** 版本号 */
    private static final long serialVersionUID = 105194027052560780L;

    /** id */
    private String id;

    /** mobileNo */
    private String mobileNo;

    /** centent */
    private String centent;

    /** 状态，0-失败，1-成功 */
    private Integer state;

    /** 消息类型，1-验证码，2-公告 */
    private Integer messageType;

    /** createTime */
    private Date createTime;

    /** updateTime */
    private Date updateTime;

    /**
     * 获取id
     * 
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置id
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取mobileNo
     * 
     * @return mobileNo
     */
    public String getMobileNo() {
        return this.mobileNo;
    }

    /**
     * 设置mobileNo
     * 
     * @param mobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取centent
     * 
     * @return centent
     */
    public String getCentent() {
        return this.centent;
    }

    /**
     * 设置centent
     * 
     * @param centent
     */
    public void setCentent(String centent) {
        this.centent = centent;
    }

    /**
     * 获取状态，0-失败，1-成功
     * 
     * @return 状态
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置状态，0-失败，1-成功
     * 
     * @param state
     *          状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取消息类型，1-验证码，2-公告
     * 
     * @return 消息类型
     */
    public Integer getMessageType() {
        return this.messageType;
    }

    /**
     * 设置消息类型，1-验证码，2-公告
     * 
     * @param messageType
     *          消息类型
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**
     * 获取createTime
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置createTime
     * 
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取updateTime
     * 
     * @return updateTime
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置updateTime
     * 
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}