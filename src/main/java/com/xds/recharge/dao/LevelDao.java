package com.xds.recharge.dao;
import com.xds.recharge.model.Level;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LevelDao {


    List<Level> findLevelByScore(@Param("score") Integer score);
}
