package com.xds.recharge.service.impl;

import com.xds.recharge.service.SmsService;
import org.springframework.stereotype.Service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendSms(String mobileNo,String centent) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String day=sdf.format(new Date());
        request.setVersion(day);
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //18072811971
        request.putQueryParameter("PhoneNumbers", mobileNo);
        request.putQueryParameter("SignName", "行东上");
        request.putQueryParameter("TemplateCode", "SMS_175690135");
        //"{ 	\"code\": \"3322\" }"
        request.putQueryParameter("TemplateParam", centent);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
