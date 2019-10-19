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
 * recharge_recode
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
public class RechargeRecode {
    /** 版本号 */
    private static final long serialVersionUID = -8540340167022145055L;

    /** id */
    private String id;

    /** 我方订单id */
    private String orderId;

    /** 手机号 */
    private String mobileNo;

    /** 充值金额，单位（厘） */
    private Integer amount;

    /** 订单状态，0-充值中，1-充值成功，10-充值失败， */
    private Integer state;

    /** 回调状态，0-充值失败，1-充值成功 */
    private Integer notifyState;

    /** 回调时间 */
    private Date notifyTime;

    /** 通道售价 */
    private Integer channelSellPrice;

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
     * 获取我方订单id
     * 
     * @return 我方订单id
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * 设置我方订单id
     * 
     * @param orderId
     *          我方订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取手机号
     * 
     * @return 手机号
     */
    public String getMobileNo() {
        return this.mobileNo;
    }

    /**
     * 设置手机号
     * 
     * @param mobileNo
     *          手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取充值金额，单位（厘）
     * 
     * @return 充值金额
     */
    public Integer getAmount() {
        return this.amount;
    }

    /**
     * 设置充值金额，单位（厘）
     * 
     * @param amount
     *          充值金额
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取订单状态，0-充值中，1-充值成功，10-充值失败，
     * 
     * @return 订单状态
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置订单状态，0-充值中，1-充值成功，10-充值失败，
     * 
     * @param state
     *          订单状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取回调状态，0-充值失败，1-充值成功
     * 
     * @return 回调状态
     */
    public Integer getNotifyState() {
        return this.notifyState;
    }

    /**
     * 设置回调状态，0-充值失败，1-充值成功
     * 
     * @param notifyState
     *          回调状态
     */
    public void setNotifyState(Integer notifyState) {
        this.notifyState = notifyState;
    }

    /**
     * 获取回调时间
     * 
     * @return 回调时间
     */
    public Date getNotifyTime() {
        return this.notifyTime;
    }

    /**
     * 设置回调时间
     * 
     * @param notifyTime
     *          回调时间
     */
    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    /**
     * 获取通道售价
     * 
     * @return 通道售价
     */
    public Integer getChannelSellPrice() {
        return this.channelSellPrice;
    }

    /**
     * 设置通道售价
     * 
     * @param channelSellPrice
     *          通道售价
     */
    public void setChannelSellPrice(Integer channelSellPrice) {
        this.channelSellPrice = channelSellPrice;
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
     * 获取creator
     * 
     * @return creator
     */
    public String getCreator() {
        return this.creator;
    }

    /**
     * 设置creator
     * 
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
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

    /**
     * 获取updator
     * 
     * @return updator
     */
    public String getUpdator() {
        return this.updator;
    }

    /**
     * 设置updator
     * 
     * @param updator
     */
    public void setUpdator(String updator) {
        this.updator = updator;
    }

    /**
     * 获取remark
     * 
     * @return remark
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置remark
     * 
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}