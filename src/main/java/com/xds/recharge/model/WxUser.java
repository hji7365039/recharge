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
 * wx_user
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
public class WxUser {
    /** 版本号 */
    private static final long serialVersionUID = -4150841631426986268L;

    /** id */
    private String id;

    /** 微信唯一标识 */
    private String openId;

    /** 手机号码 */
    private String mobileNo;

    /** 是否删除，0-删除，1-正常 */
    private Integer state;

    /** 创建时间 */
    private Date createTime;

    /** 创建人 */
    private String creator;

    /** 更新时间 */
    private Date updateTime;

    /** 操作人 */
    private String updator;

    /** 备注 */
    private String remark;

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
     * 获取微信唯一标识
     * 
     * @return 微信唯一标识
     */
    public String getOpenId() {
        return this.openId;
    }

    /**
     * 设置微信唯一标识
     * 
     * @param openId
     *          微信唯一标识
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取手机号码
     * 
     * @return 手机号码
     */
    public String getMobileNo() {
        return this.mobileNo;
    }

    /**
     * 设置手机号码
     * 
     * @param mobileNo
     *          手机号码
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取是否删除，0-删除，1-正常
     * 
     * @return 是否删除
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置是否删除，0-删除，1-正常
     * 
     * @param state
     *          是否删除
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置创建时间
     * 
     * @param createTime
     *          创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     * 
     * @return 创建人
     */
    public String getCreator() {
        return this.creator;
    }

    /**
     * 设置创建人
     * 
     * @param creator
     *          创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取更新时间
     * 
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置更新时间
     * 
     * @param updateTime
     *          更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取操作人
     * 
     * @return 操作人
     */
    public String getUpdator() {
        return this.updator;
    }

    /**
     * 设置操作人
     * 
     * @param updator
     *          操作人
     */
    public void setUpdator(String updator) {
        this.updator = updator;
    }

    /**
     * 获取备注
     * 
     * @return 备注
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置备注
     * 
     * @param remark
     *          备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}