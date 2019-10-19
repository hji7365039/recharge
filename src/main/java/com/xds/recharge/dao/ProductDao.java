package com.xds.recharge.dao;
import com.xds.recharge.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductDao {

    List<Product> findProductByCondition(Map<Object,Object> map);
}
