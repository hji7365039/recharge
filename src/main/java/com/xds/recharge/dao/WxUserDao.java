package com.xds.recharge.dao;
import com.xds.recharge.model.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WxUserDao {

    WxUser findWxUserByCondition(WxUser wxUser);

    //List<WxUser> selecyByopenId(@Param("openId") String openId);
}
