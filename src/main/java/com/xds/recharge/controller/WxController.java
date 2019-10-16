package com.xds.recharge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="wx")
public class WxController {


    @ResponseBody
    @RequestMapping(value="callback")
    public String callback(){
        return "welcome";
    }
}
