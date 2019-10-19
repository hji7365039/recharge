package com.xds.recharge.service.impl;

import com.xds.recharge.dao.AnswerDao;
import com.xds.recharge.dao.LevelDao;
import com.xds.recharge.dao.ProductDao;
import com.xds.recharge.dao.TopicDao;
import com.xds.recharge.dto.HandInAnswerDto;
import com.xds.recharge.dto.HandInAnswerResponseDto;
import com.xds.recharge.model.Level;
import com.xds.recharge.model.Product;
import com.xds.recharge.model.Topic;
import com.xds.recharge.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public HandInAnswerResponseDto handInAnswer(HandInAnswerDto dto){
        HandInAnswerResponseDto responseDto=new HandInAnswerResponseDto();
        Integer sumScore= answerDao.getSumScore(dto.getAnswerIds());

        List<Level> levelList=levelDao.findLevelByScore(sumScore);
        if (levelList!=null&&levelList.size()>0){
            //匹配到分数，说明获得了奖品
            Level lv=levelList.get(0);

            Map<Object,Object> map=new HashMap<>();
            map.put("levelId",lv.getId());

            List<Product> productList= productDao.findProductByCondition(map);
            if(productList!=null&&productList.size()>0){

                int random=(int)(Math.random()*1000);

                int [] odd={0,0};
                for (Product product1: productList) {
                    odd[1]=odd[0]+product1.getOdds();

                    if(random>=odd[0]&&random<odd[1]){
                        System.out.println("获得奖励="+product1);
                        //调用充值接口为其充值




                        //返回成功
                        responseDto.setState(1);
                        responseDto.setCentent("恭喜你获得"+product1.getProductName()+"，我们将在24小时内为您充值到账，请耐心等待。");
                        break;
                    }
                    odd[0]=odd[1];
                }
            }

        }else{
            //未匹配到分数，说明分数不够获取奖品
            responseDto.setState(0);
            responseDto.setCentent("非常遗憾，您没有获得奖励，感谢您的参与，关注\"蒋村街道\"微信公众号，更多活动奖品等你拿！");
        }
        return  responseDto;
    }


//    private void recharge(){
//        String faceValue="1000";
//        String serialNo=UUID.randomUUID().toString();
//        return ResponseResult.Success(rechargeService.recharge(mobileNo,faceValue,serialNo));
//    }

}
