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
 * wsgz_order
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
public class WsgzOrder {
    /** 版本号 */
    private static final long serialVersionUID = 2729714178984425116L;

    /** id */
    private String id;

    /** openId */
    private String openId;

    /** wxName */
    private String wxName;

    /** mobileNo */
    private String mobileNo;

    /** 得分 */
    private Integer score;

    /** 是否中奖，0-未中奖，1-已经中奖 */
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
     * 获取openId
     * 
     * @return openId
     */
    public String getOpenId() {
        return this.openId;
    }

    /**
     * 设置openId
     * 
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取wxName
     * 
     * @return wxName
     */
    public String getWxName() {
        return this.wxName;
    }

    /**
     * 设置wxName
     * 
     * @param wxName
     */
    public void setWxName(String wxName) {
        this.wxName = wxName;
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
     * 获取得分
     * 
     * @return 得分
     */
    public Integer getScore() {
        return this.score;
    }

    /**
     * 设置得分
     * 
     * @param score
     *          得分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取是否中奖，0-未中奖，1-已经中奖
     * 
     * @return 是否中奖
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置是否中奖，0-未中奖，1-已经中奖
     * 
     * @param state
     *          是否中奖
     */
    public void setState(Integer state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "WsgzOrder{" +
                "id='" + id + '\'' +
                ", openId='" + openId + '\'' +
                ", wxName='" + wxName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", score=" + score +
                ", state=" + state +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updator='" + updator + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}