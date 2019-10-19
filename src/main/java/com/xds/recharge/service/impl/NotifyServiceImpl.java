package com.xds.recharge.service.impl;

import com.xds.recharge.dao.RechargeRecodeDao;
import com.xds.recharge.dto.RechargeNotifyDto;
import com.xds.recharge.model.RechargeRecode;
import com.xds.recharge.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    RechargeRecodeDao rechargeRecodeDao;

    @Override
    public void rechargeNotify(RechargeNotifyDto dto){
        String rechargeRecodeId= dto.getDownstreamSerialno();
        int state=10;
        int notifyState=0;
        if(dto.getStatus().equals("2")){
            state=1;
            notifyState=1;
        }else if (dto.getStatus().equals("3")){
            state=10;
            notifyState=0;
        }
        RechargeRecode rechargeRecode= new RechargeRecode();
        rechargeRecode.setId(rechargeRecodeId);
        rechargeRecode.setState(state);
        rechargeRecode.setNotifyState(notifyState);
        rechargeRecode.setNotifyTime(new Date());
        rechargeRecodeDao.updateRechargeRecodeByNotify(rechargeRecode);

    }

}
