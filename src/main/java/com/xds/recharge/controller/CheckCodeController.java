package com.xds.recharge.controller;


import com.xds.recharge.common.ResponseResult;
import com.xds.recharge.service.CheckCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/check")
public class CheckCodeController {

    @Autowired
    CheckCodeService checkCodeService;

    @ResponseBody
    @RequestMapping(value="/getCheckCode")
    public ResponseResult getCheckCode(String mobileNo){
        if(mobileNo==null||mobileNo.equals("")){
            return ResponseResult.Error("手机号为空");
        }
        return ResponseResult.Success(checkCodeService.saveCheckCode(mobileNo));
    }


    @ResponseBody
    @RequestMapping(value="/checkCode")
    public ResponseResult checkCode(String code,String mobileNo){
        return ResponseResult.Success(checkCodeService.checkCode(code,mobileNo));
    }
}
