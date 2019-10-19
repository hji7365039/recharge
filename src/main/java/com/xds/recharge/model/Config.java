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
 * config
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
public class Config {
    /** 版本号 */
    private static final long serialVersionUID = -185037120686672962L;

    /** id */
    private String id;

    /** key */
    private String key;

    /** value */
    private String value;

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
     * 获取key
     * 
     * @return key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * 设置key
     * 
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取value
     * 
     * @return value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * 设置value
     * 
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
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