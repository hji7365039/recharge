package com.xds.recharge.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinyi on 2016/10/31.
 */
public class ResponseResult {
    public enum ResultEnum{
        confirm("confirm"),
        undefined("undefined"),
        success("success"),
        fail("fail"),
        nologin("nologin");
        private String text;

        ResultEnum(String text) {
            this.text = text;
        }

        public String toString() {
            return this.text;
        }
    }
    private ResultEnum result;
    private String message;
    private String type;
    private Object reason;
    private Object data;
    private Object info;

    private ResponseResult(ResultEnum result){
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getReason() {
        return reason;
    }

    public void setReason(Object reason) {
        this.reason = reason;
    }

    public ResultEnum getResult() {
        return result;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ResponseResult> toList(){
        List<ResponseResult> list = new ArrayList<>();
        list.add(this);
        return list;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("result:").append(result.toString()).append("\n");
        sb.append("reason:").append(reason).append("\n");
        sb.append("message:").append(message).append("\n");
        sb.append("type:").append(type).append("\n");
        sb.append("data:").append(data).append("\n");
        sb.append("info:").append(info).append("\n");
        return sb.toString();
    }

    public static ResponseResult Success(){
        return new ResponseResult(ResultEnum.success);
    }

    public static ResponseResult Success(Object data){
        ResponseResult result = new ResponseResult(ResultEnum.success);
        result.setData(data);
        return result;
    }

    public static ResponseResult Fail(String reason){
        ResponseResult result = new ResponseResult(ResultEnum.fail);
        result.setMessage(reason);
        result.setReason(reason);
        return result;
    }

    public static ResponseResult NoLogin(String reason){
        ResponseResult result = new ResponseResult(ResultEnum.nologin);
        result.setMessage(reason);
        result.setReason(reason);
        return result;
    }

    public static ResponseResult Confirm(String reason){
        ResponseResult result = new ResponseResult(ResultEnum.confirm);
        result.setMessage(reason);
        result.setReason(reason);
        return result;
    }

    public static ResponseResult Undefined(Object data){
        ResponseResult result = new ResponseResult(ResultEnum.undefined);
        result.setInfo(data);
        return result;
    }

    public static ResponseResult FailReason(Object reason){
        ResponseResult result = new ResponseResult(ResultEnum.fail);
        result.setReason(reason);
        return result;
    }



    public static ResponseResult Error(){
        return Error("系统错误，请联系系统管理员！");
    }

    public static ResponseResult Error(String reason){
        ResponseResult result = new ResponseResult(ResultEnum.fail);
        result.setReason(reason);
        result.setMessage(reason);
        return result;
    }

}
