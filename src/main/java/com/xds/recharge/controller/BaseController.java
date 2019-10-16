package com.xds.recharge.controller;


import com.xds.recharge.common.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/base")
public class BaseController {


    @ResponseBody
    @RequestMapping(value="answer", method = RequestMethod.GET)
    public ResponseResult answer(){
        return ResponseResult.Success();
    }
}
