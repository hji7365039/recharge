package com.xds.recharge.controller;


import com.xds.recharge.common.ResponseResult;
import com.xds.recharge.dto.LatitudeAndLongitudeDto;
import com.xds.recharge.dto.RechargeNotifyDto;
import com.xds.recharge.service.CheckLocationService;
import com.xds.recharge.service.NotifyService;
import com.xds.recharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/base")
public class BaseController {

    @Autowired
    RechargeService rechargeService;

    @Autowired
    NotifyService notifyService;

    @Autowired
    CheckLocationService checkLocationService;


    @ResponseBody
    @RequestMapping(value="queryBalance", method = RequestMethod.GET)
    public ResponseResult queryBalance(){
        return ResponseResult.Success(rechargeService.queryBalance());
    }


    @ResponseBody
    @RequestMapping(value="rechargeNotify", method = RequestMethod.GET)
    public String rechargeNotify(RechargeNotifyDto dto){
        System.out.println(dto.toString());
        notifyService.rechargeNotify(dto);
        return "success";
    }

//    @ResponseBody
//    @RequestMapping(value="recharge", method = RequestMethod.GET)
//    public ResponseResult recharge(String mobileNo){
//        String faceValue="1000";
//        String serialNo=UUID.randomUUID().toString();
//        return ResponseResult.Success(rechargeService.recharge(mobileNo,faceValue,serialNo));
//    }


    @ResponseBody
    @RequestMapping(value="checkLocation", method = RequestMethod.GET)
    public ResponseResult checkLocation(LatitudeAndLongitudeDto latitudeAndLongitudeDto,HttpServletRequest request){

        return ResponseResult.Success(checkLocationService.checkLocation(latitudeAndLongitudeDto,request));
    }

}
