package com.xds.recharge.service;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.RechargeApplicationTests;
import com.xds.recharge.dao.WxDao;
import com.xds.recharge.dto.WxUserDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;


public class WxTest extends RechargeApplicationTests {

    @Autowired
    private WxService wxService;

    @Test
    public void testGetAccessToken(){
        JSONObject result = wxService.getAccessToken("081OMor914NnKO1B5jr91RWjr91OMorh");
        System.out.println(result);
        System.out.println(result.getString("access_token"));
    }

    @Autowired
    private CheckCodeService checkCodeService;

    @Test
    public void testGetCode(){
        checkCodeService.saveCheckCode("15606527728");
    }

    @Autowired
    private WxDao wxDao;

    @Test
    public void testInsert(){
        WxUserDto wxUser = new WxUserDto();
        wxUser.setOpenId("oErJqsw65XF7_vaKlruTMEs5jTYk1");
        wxUser.setMobileNo("15606527728");
        wxUser.setId(UUID.randomUUID().toString());
        wxDao.insertWxUser(wxUser);
    }

    @Test
    public void testGetSubscribe(){
        isSubscribe("26_Or1JKlZqORMOnPWkm2rzKwrXBXQhJmZEaco9ZRXeouGnZbVhdA6KJv8rXUix_bLf4g-LlLP_c4gdWR9Hn_VrLA","oErJqs3iXo6ff3bfD4Bk9erI-tHA");
    }

    @Value("${wx.lang}")
    private String lang;

    @Value("${wx.getInfoUrl}")
    private String getInfoUrl;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 是否订阅
     * @return
     */
    public boolean isSubscribe(String token, String openid){
        JSONObject result = JSONObject.parseObject(restTemplate.getForObject("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx29c49905292b67dd&secret=009025655e21909d94a3dfb123607609", String.class));
        System.out.println(result);
        String url = getInfoUrl + "?access_token=" + result.getString("access_token") + "&openid=" + openid + "&lang=" + lang;
        System.out.println(url);
        System.out.println(JSONObject.parseObject(restTemplate.getForObject(url, String.class)));
        return true;
    }
}
