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
    @RequestMapping(value="answer", method = RequestMethod.GET)
    public ResponseResult answer(){
        return ResponseResult.Success();
    }


    @ResponseBody
    @RequestMapping(value="querybalance", method = RequestMethod.GET)
    public String querybalance(){
        return rechargeService.queryBalance();
    }
}
