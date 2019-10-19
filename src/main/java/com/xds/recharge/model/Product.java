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
 * product
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
public class Product {
    /** 版本号 */
    private static final long serialVersionUID = 6216786030953759535L;

    /** id */
    private String id;

    /** 面值 */
    private String productName;

    /** 面值,1、20、30 */
    private Integer faceValue;

    /** 奖品等级 */
    private String levelId;

    /** 中奖几率 */
    private Integer odds;

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
     * 获取面值
     * 
     * @return 面值
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 设置面值
     * 
     * @param productName
     *          面值
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取面值,1、20、30
     * 
     * @return 面值
     */
    public Integer getFaceValue() {
        return this.faceValue;
    }

    /**
     * 设置面值,1、20、30
     * 
     * @param faceValue
     *          面值
     */
    public void setFaceValue(Integer faceValue) {
        this.faceValue = faceValue;
    }

    /**
     * 获取奖品等级
     * 
     * @return 奖品等级
     */
    public String getLevelId() {
        return this.levelId;
    }

    /**
     * 设置奖品等级
     * 
     * @param levelId
     *          奖品等级
     */
    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    /**
     * 获取中奖几率
     * 
     * @return 中奖几率
     */
    public Integer getOdds() {
        return this.odds;
    }

    /**
     * 设置中奖几率
     * 
     * @param odds
     *          中奖几率
     */
    public void setOdds(Integer odds) {
        this.odds = odds;
    }

    /**
     * 获取0-启用，1-禁用
     * 
     * @return 0-启用
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置0-启用，1-禁用
     * 
     * @param state
     *          0-启用
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
}