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
 * user
 * 
 * @author huangjinhao
 * @version 1.0.0 2019-10-18
 */
public class User {
    /** 版本号 */
    private static final long serialVersionUID = -7995899941784984147L;

    /** userId */
    private String userId;

    /** userName */
    private String userName;

    /** password */
    private String password;

    /** deptId */
    private String deptId;

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

    /** remarke */
    private String remarke;

    /**
     * 获取userId
     * 
     * @return userId
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置userId
     * 
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取userName
     * 
     * @return userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置userName
     * 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取password
     * 
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取deptId
     * 
     * @return deptId
     */
    public String getDeptId() {
        return this.deptId;
    }

    /**
     * 设置deptId
     * 
     * @param deptId
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
     * 获取remarke
     * 
     * @return remarke
     */
    public String getRemarke() {
        return this.remarke;
    }

    /**
     * 设置remarke
     * 
     * @param remarke
     */
    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }
}