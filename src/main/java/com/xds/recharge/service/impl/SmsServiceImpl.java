package com.xds.recharge.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.IClientProfile;
import com.xds.recharge.service.SmsService;
import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;


@Service
public class SmsServiceImpl implements SmsService {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAI4FpKGd84SPLBLKseEyqZ";
    static final String accessKeySecret = "ga6gY5E5tFYQvE3Ft4Svpl12Wmj7bQ";

    @Override
    public SendSmsResponse sendSms(String mobileNo,String centent)  {
        try {
            //可自助调整超时时间
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");

            //初始化acsClient,暂不支持region化
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);


            IAcsClient acsClient = new DefaultAcsClient(profile);

            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号
            request.setPhoneNumbers(mobileNo);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("行东上");
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode("SMS_175690135");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(centent);

            //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");

            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            //request.setOutId("yourOutId");

            //hint 此处可能会抛出异常，注意catch
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            System.out.println(sendSmsResponse.getMessage());
            System.out.println(sendSmsResponse.getBizId());
            System.out.println(sendSmsResponse.getRequestId());
            System.out.println(sendSmsResponse.getCode());
            return sendSmsResponse;
        }catch (ClientException ce){
            ce.printStackTrace();
            return null;
        }



//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FuvWfftn6TMQgf6gCS5", "7raWuZBGG3OEYqOkLho0ad6hqquZqs");
//        IAcsClient client = new DefaultAcsClient(profile);
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String day=sdf.format(new Date());
//        request.setVersion(day);
//        request.setAction("SendSms");
//        request.putQueryParameter("RegionId", "cn-hangzhou");
//        //18072811971
//        request.putQueryParameter("PhoneNumbers", mobileNo);
//        request.putQueryParameter("SignName", "行东上");
//        request.putQueryParameter("TemplateCode", "SMS_175690135");
//        //"{ 	\"code\": \"3322\" }"
//        request.putQueryParameter("TemplateParam", centent);
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
    }
}
