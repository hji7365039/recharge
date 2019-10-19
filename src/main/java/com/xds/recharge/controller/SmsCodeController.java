package com.xds.recharge.controller;


import com.xds.recharge.common.ResponseResult;
import com.xds.recharge.service.CheckCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/smsCode")
public class SmsCodeController {

    @Autowired
    CheckCodeService checkCodeService;

    @ResponseBody
    @RequestMapping(value="/getSmsCode", method = RequestMethod.GET)
    public ResponseResult getCheckCode(String mobileNo){
        if(StringUtils.isBlank(mobileNo)){
            return ResponseResult.Error("手机号为空");
        }
        return ResponseResult.Success(checkCodeService.saveCheckCode(mobileNo));
    }


    @ResponseBody
    @RequestMapping(value="/checkSmsCode", method = RequestMethod.GET)
    public ResponseResult checkCode(String code,String mobileNo,HttpServletRequest request){
        if(StringUtils.isBlank(mobileNo)){
            return ResponseResult.Error("手机号为空");
        }
        String openid="";
        if(request.getSession().getAttribute("openid")==null){
            return ResponseResult.Error("openid为空");
        }else{
            openid=(String)request.getSession().getAttribute("openid");
            return ResponseResult.Success(checkCodeService.checkCode(code, mobileNo, openid));
        }

    }
}
