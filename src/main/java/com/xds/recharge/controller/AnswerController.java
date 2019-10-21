package com.xds.recharge.controller;


import com.xds.recharge.common.ResponseResult;
import com.xds.recharge.dto.HandInAnswerDto;
import com.xds.recharge.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    /**
     * 获取题目
     * @return
     */
    @ResponseBody
    @RequestMapping(value="getAnswer", method = RequestMethod.GET)
    public ResponseResult getAnswer(){
        return ResponseResult.Success(answerService.getAnswer());
    }

    /**
     * 上交答案
     * @return
     */
    @ResponseBody
    @RequestMapping(value="handInAnswer", method = RequestMethod.POST)
    public ResponseResult handInAnswer(@RequestBody HandInAnswerDto dto, HttpServletRequest request){
        if (dto.getAnswerIds()==null||dto.getAnswerIds().size()<=0){
            return ResponseResult.Error("答案不完整，请重新答题！");
        }

        String openid="";
        String inSide="";
        if(request.getSession().getAttribute("openid")==null){
            return ResponseResult.Error("openid为空");
        }else{
            openid=(String)request.getSession().getAttribute("openid");
            inSide=(String)request.getSession().getAttribute("inSide");
            return ResponseResult.Success(answerService.handInAnswer(dto,openid,inSide));
        }

    }


}
