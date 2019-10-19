package com.xds.recharge.dao;

import com.xds.recharge.dto.WxUserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxDao {

    void insertWxUser(WxUserDto wxUserDto);

    void updateByOpenId(WxUserDto wxUserDto);

}
