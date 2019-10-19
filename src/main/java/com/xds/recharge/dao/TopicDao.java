package com.xds.recharge.dao;
import com.xds.recharge.model.Topic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicDao {


    List<Topic> findTopicAll();
}
