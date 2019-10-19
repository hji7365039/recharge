package com.xds.recharge.dao;
import com.xds.recharge.model.WxUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxUserDao {

    WxUser findWxUserByCondition(WxUser wxUser);
}
