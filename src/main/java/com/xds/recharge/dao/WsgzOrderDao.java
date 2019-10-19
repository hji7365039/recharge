package com.xds.recharge.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WsgzOrderDao {

    Integer selectCountByMobileNo(@Param("mobileNo") String mobileNo);



}
