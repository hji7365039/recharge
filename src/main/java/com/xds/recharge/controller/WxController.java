package com.xds.recharge.controller;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.common.ResponseResult;
import com.xds.recharge.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="wx")
public class WxController {


    @ResponseBody
    @RequestMapping(value="callback")
    public String callback(){
        return "welcome";
    }

    @Autowired
    private WxService wxService;

    /**
     * 获取accessToken
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value="getAccessToken", method = RequestMethod.GET)
    public ResponseResult getAccessToken(String code,HttpServletRequest request){
        return ResponseResult.Success(wxService.getAccessToken(code,request)) ;
    }

}
