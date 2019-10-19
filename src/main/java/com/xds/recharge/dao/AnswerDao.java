package com.xds.recharge.dao;

import com.xds.recharge.model.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AnswerDao {

    List<Answer> findAnswerByCondition(Map<String,String> map);

    Integer getSumScore(@Param("list") List<String> list);
}
