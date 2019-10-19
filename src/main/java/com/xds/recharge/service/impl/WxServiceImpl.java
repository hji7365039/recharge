package com.xds.recharge.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xds.recharge.dao.WsgzOrderDao;
import com.xds.recharge.dao.WxDao;
import com.xds.recharge.dao.WxUserDao;
import com.xds.recharge.dto.GetAccessTokenDto;
import com.xds.recharge.dto.WxUserDto;
import com.xds.recharge.model.WxUser;
import com.xds.recharge.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
public class WxServiceImpl implements WxService {

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Value("${wx.lang}")
    private String lang;

    @Value("${wx.grant_type}")
    private String grant_type;

    @Value("${wx.getAccessTokenUrl}")
    private String getAccessTokenUrl;

    @Value("${wx.getInfoUrl}")
    private String getInfoUrl;

    @Value("${wx.getTokenUrl}")
    private String getTokenUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WsgzOrderDao wsgzOrderDao;

    @Autowired
    WxUserDao wxUserDao;

    @Override
    public GetAccessTokenDto getAccessToken(String code,HttpServletRequest request) {
        String url = getAccessTokenUrl + "?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=" + grant_type;
        JSONObject result = JSONObject.parseObject(restTemplate.getForObject(url, String.class));
        GetAccessTokenDto  getAccessTokenDto= new GetAccessTokenDto();
        //判断openid
        String openid="";

        //测试
//        openid="123123123123";
//        request.getSession().setAttribute("openid",openid);

        if(result.getString("openid")!=null){
            openid=result.getString("openid");

            //判断是否关注蒋村街道微信公众号
            if(isSubscribe(openid)){
                getAccessTokenDto.setPage(-1);
            }else{
                request.getSession().setAttribute("openid",openid);

                getAccessTokenDto.setAccessTokenResult(result.toJSONString());

                //查看该openid是否存在我们数据库
                WxUser wxUser= new WxUser();
                wxUser.setOpenId(openid);
                wxUser= wxUserDao.findWxUserByCondition(wxUser);
                if(wxUser!=null){
                    //判断是否已经参与答题
                    int count= wsgzOrderDao.selectCountByMobileNo(wxUser.getMobileNo());
                    if(count>0){
                        //直接给最终页面
                        getAccessTokenDto.setPage(2);
                        getAccessTokenDto.setResult("答题活动机会只有一次哦!");

                    }else{
                        //直接跳转到答题页面
                        getAccessTokenDto.setPage(1);
                    }
                }else{
                    //否则，可以进入绑定手机号页面
                    getAccessTokenDto.setPage(0);
                }
            }

        }
        return getAccessTokenDto;
    }

    /**
     * 是否订阅
     * @return
     */
    private boolean isSubscribe(String openid){
        // 获取公众号token
        JSONObject result = JSONObject.parseObject(restTemplate.getForObject(getTokenUrl + "?grant_type=client_credential&appid=" + appid + "&secret=" + secret, String.class));
        String url = getInfoUrl + "?access_token=" + result.getString("access_token") + "&openid=" + openid + "&lang=" + lang;
        // 判断用户是否订阅
        result = JSONObject.parseObject(restTemplate.getForObject(url, String.class));
        return result.getInteger("subscribe") == 1 ? true :false;
    }

}
