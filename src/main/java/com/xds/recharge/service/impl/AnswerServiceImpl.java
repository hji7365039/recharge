package com.xds.recharge.service.impl;

import com.xds.recharge.dao.*;
import com.xds.recharge.dto.HandInAnswerDto;
import com.xds.recharge.dto.HandInAnswerResponseDto;
import com.xds.recharge.model.*;
import com.xds.recharge.service.AnswerService;
import com.xds.recharge.service.RechargeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    TopicDao topicDao;

    @Autowired
    AnswerDao answerDao;

    @Autowired
    LevelDao levelDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    RechargeService rechargeService;

    @Autowired
    WxUserDao wxUserDao;

    @Autowired
    RechargeRecodeDao rechargeRecodeDao;

    @Autowired
    WsgzOrderDao wsgzOrderDao;

    @Override
    public List<Topic> getAnswer(){
        List<Topic> topicList=topicDao.findTopicAll();
        for (Topic topic: topicList ) {
            Map<String,String> map = new HashMap<>();
            map.put("topicId",topic.getId());
            topic.setAnswerList(answerDao.findAnswerByCondition(map));
        }
        return topicList;
    }

    @Override
    public HandInAnswerResponseDto handInAnswer(HandInAnswerDto dto, String openId,String inSide){
        HandInAnswerResponseDto responseDto=new HandInAnswerResponseDto();
        Integer sumScore= answerDao.getSumScore(dto.getAnswerIds());
        String centent="非常遗憾，您没有获得奖励，感谢您的参与，关注\"蒋村街道\"微信公众号，了解更多精彩内容！";
        responseDto.setState(0);
        responseDto.setCentent(centent);
        //如果不在范围内，直接没有奖励
        if(inSide.equals("false")){
            return responseDto;
        }


        //中奖状态,0未中奖,1已中奖
        int state=0;
        Product product=getPrize(sumScore);
        if(product!=null){
            state=1;
        }


        String orderId=UUID.randomUUID().toString();

        //暂时允许重复答题  doRecharge也注释了 不进行充值

//        //根据openid获取手机号
//        WxUser wxUser= new WxUser();
//        wxUser.setOpenId(openId);
//        wxUser=wxUserDao.findWxUserByCondition(wxUser);
//        if( !StringUtils.isBlank(wxUser.getMobileNo())){
//            //插入order表，记录中奖的分数、金额、openid
//            WsgzOrder wsgzOrder= new WsgzOrder();
//            wsgzOrder.setId(orderId);
//            wsgzOrder.setOpenId(openId);
//            wsgzOrder.setMobileNo(wxUser.getMobileNo());
//            wsgzOrder.setScore(sumScore);
//            wsgzOrder.setState(state);
//            wsgzOrder.setCreateTime(new Date());
//            wsgzOrder.setCreator("system");
//            wsgzOrderDao.insertWsgzOrder(wsgzOrder);
//            System.out.println(wsgzOrder.toString());
//        }
        if(product!=null){
            doRecharge(openId,product,responseDto,orderId);
        }
        return  responseDto;
    }

    /**
     * 进行充值
     * @param openId
     * @param product
     */
   private void doRecharge(String openId,Product product,HandInAnswerResponseDto responseDto,String orderId){

       WxUser wxUser= new WxUser();
       wxUser.setOpenId(openId);
       wxUser=wxUserDao.findWxUserByCondition(wxUser);
       if( !StringUtils.isBlank(wxUser.getMobileNo())){
           String sFaceValue=(product.getFaceValue()*1000)+"";
           //生成订单、插入数据
           String id=UUID.randomUUID().toString();

           RechargeRecode rechargeRecode= new RechargeRecode();
           rechargeRecode.setId(id);
           rechargeRecode.setAmount(product.getFaceValue());
           rechargeRecode.setMobileNo(wxUser.getMobileNo());
           rechargeRecode.setCreateTime(new Date());
           rechargeRecode.setCreator("system");
           rechargeRecode.setState(0);
           rechargeRecode.setOrderId(orderId);

           //暂时允许重复答题操作
//           rechargeRecodeDao.insertRechargeRecode(rechargeRecode);
//
//           //进行充值操作
//           rechargeService.recharge(wxUser.getMobileNo(),sFaceValue,id);

           //返回成功
           responseDto.setState(1);
           responseDto.setCentent("恭喜你获得"+product.getProductName()+"，我们将在24小时内为您充值到账，请耐心等待。");
       }
   }

    /**
     * 算法，获取奖品
     * @param sumScore
     * @return
     */
    private Product getPrize(int sumScore){
        List<Level> levelList=levelDao.findLevelByScore(sumScore);
        if (levelList!=null&&levelList.size()>0) {
            //匹配到分数，说明获得了奖品
            Level lv = levelList.get(0);
            Map<Object, Object> map = new HashMap<>();
            map.put("levelId", lv.getId());
            List<Product> productList = productDao.findProductByCondition(map);
            if(productList!=null&&productList.size()>0){
                //计算是否中奖
                int random=(int)(Math.random()*10000);

                int [] odd={0,0};
                for (Product product1: productList) {
                    odd[1]=odd[0]+product1.getOdds();

                    if(random>=odd[0]&&random<=odd[1]){
                        System.out.println("获得奖励="+product1);
                        //调用充值接口为其充值
                        return product1;
                    }
                    odd[0]=odd[1];
                }
            }
        }
        return null;
    }


//    private void recharge(){
//        String faceValue="1000";
//        String serialNo=UUID.randomUUID().toString();
//        return ResponseResult.Success(rechargeService.recharge(mobileNo,faceValue,serialNo));
//    }

}
