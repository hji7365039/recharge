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
 * level
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
public class Level {
    /** 版本号 */
    private static final long serialVersionUID = 2654062413917971941L;

    /** id */
    private String id;

    /** 描述 */
    private String centent;

    /** 最小分数 */
    private Integer minScore;

    /** 最高分数 */
    private Integer maxScore;

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
     * 获取描述
     * 
     * @return 描述
     */
    public String getCentent() {
        return this.centent;
    }

    /**
     * 设置描述
     * 
     * @param centent
     *          描述
     */
    public void setCentent(String centent) {
        this.centent = centent;
    }

    /**
     * 获取最小分数
     * 
     * @return 最小分数
     */
    public Integer getMinScore() {
        return this.minScore;
    }

    /**
     * 设置最小分数
     * 
     * @param minScore
     *          最小分数
     */
    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    /**
     * 获取最高分数
     * 
     * @return 最高分数
     */
    public Integer getMaxScore() {
        return this.maxScore;
    }

    /**
     * 设置最高分数
     * 
     * @param maxScore
     *          最高分数
     */
    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
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