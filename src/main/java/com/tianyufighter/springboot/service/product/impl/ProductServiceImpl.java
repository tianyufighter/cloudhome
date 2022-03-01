package com.tianyufighter.springboot.service.product.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianyufighter.springboot.dao.ProductDao;
import com.tianyufighter.springboot.domain.Product;
import com.tianyufighter.springboot.service.product.ProductService;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 将商品存储数据库
     * @param product 商品的实体类
     * @return 影响数据库的行数
     */
    @Override
    public int insertProduct(Product product) {
        return productDao.insertProduct(product);
    }

    @Override
    public List<Product> queryProduct() {
        return productDao.queryProduct();
    }

    @Override
    public PageInfo<Product> findAllProductByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        List<Product> lists = productDao.queryProduct();
        Collections.reverse(lists);
        PageInfo<Product> pageInfo = new PageInfo<Product>(lists);
        return pageInfo;
    }
}
