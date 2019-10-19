package com.xds.recharge.dao;

import com.xds.recharge.dto.WxUserDto;
import com.xds.recharge.model.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WxDao {

    void insertWxUser(WxUserDto wxUserDto);

    void updateByOpenId(WxUserDto wxUserDto);



}
