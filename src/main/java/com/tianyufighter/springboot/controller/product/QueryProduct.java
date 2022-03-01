package com.tianyufighter.springboot.controller.product;

import com.github.pagehelper.PageInfo;
import com.tianyufighter.springboot.dao.ProductDao;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.Product;
import com.tianyufighter.springboot.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class QueryProduct {
    @Autowired
    private ProductService productService;

    @RequestMapping("/queryProductByPage")
    public CommonResult<PageInfo<Product>> queryProductByPage(HttpServletRequest request) {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        PageInfo<Product> pageInfo = productService.findAllProductByPage(pageNum, pageSize);
        if(pageInfo != null) {
            return new CommonResult<PageInfo<Product>>(200, "在数据库中成功找到请求数据", pageInfo);
        } else {
            return new CommonResult<PageInfo<Product>>(444, "未在数据库中找到请求数据", pageInfo);
        }
    }
}
