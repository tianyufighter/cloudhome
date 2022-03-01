package com.tianyufighter.springboot.dao;

import com.tianyufighter.springboot.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作二手商品的接口
 */
@Mapper
public interface ProductDao {
    /**
     * 向数据库中存入商品的信息
     * @param product 商品实体类
     * @return 影响数据库的行数
     */
    int insertProduct(Product product);

    List<Product> queryProduct();
}
