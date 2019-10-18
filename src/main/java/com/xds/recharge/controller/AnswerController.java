package com.xds.recharge.controller;


import com.xds.recharge.common.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @ResponseBody
    @RequestMapping(value="getAnswer", method = RequestMethod.GET)
    public ResponseResult getAnswer(){
        return ResponseResult.Success();
    }
}
