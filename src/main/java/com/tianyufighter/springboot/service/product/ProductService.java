package com.tianyufighter.springboot.service.product;

import com.github.pagehelper.PageInfo;
import com.tianyufighter.springboot.domain.Product;

import java.util.List;

/**
 * 存储商品信息
 */
public interface ProductService {
    int insertProduct(Product product);
    List<Product> queryProduct();
    PageInfo<Product> findAllProductByPage(int pageNum, int pageSize);
}
