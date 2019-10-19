package com.xds.recharge.controller;


import com.xds.recharge.common.ResponseResult;
import com.xds.recharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/base")
public class BaseController {

    @Autowired
    RechargeService rechargeService;


    @ResponseBody
    @RequestMapping(value="queryBalance", method = RequestMethod.GET)
    public ResponseResult queryBalance(){
        return ResponseResult.Success(rechargeService.queryBalance());
    }


//    @ResponseBody
//    @RequestMapping(value="recharge", method = RequestMethod.GET)
//    public ResponseResult recharge(String mobileNo){
//        String faceValue="1000";
//        String serialNo=UUID.randomUUID().toString();
//        return ResponseResult.Success(rechargeService.recharge(mobileNo,faceValue,serialNo));
//    }





}
