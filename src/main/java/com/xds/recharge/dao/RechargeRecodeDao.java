package com.xds.recharge.dao;
import com.xds.recharge.model.RechargeRecode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RechargeRecodeDao {

    int insertRechargeRecode(RechargeRecode rechargeRecode);

    int updateRechargeRecode(RechargeRecode rechargeRecode);

    int updateRechargeRecodeByNotify(RechargeRecode rechargeRecode);
}
