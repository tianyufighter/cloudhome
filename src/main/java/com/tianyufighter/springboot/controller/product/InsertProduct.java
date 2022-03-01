package com.tianyufighter.springboot.controller.product;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.Product;
import com.tianyufighter.springboot.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@Slf4j
public class InsertProduct {
    @Autowired
    private ProductService productService;

    /**
     * 处理用户发送的商品请求
     */
    @RequestMapping(value = "/storeProduct", method = RequestMethod.POST)
    public CommonResult storeProduct(HttpServletRequest request) {
        System.out.println("接收到了来自客户端的请求");
        // 获取上传的文件
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
        MultipartFile multipartFile = multipartRequest.getFile("image");
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        // 文件保存路径
        String filePath = "/opt/cloudhouse/cloudhouseImage/goods/";
        // 判断文件夹是否存在，不存在则创建
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();
        }
        String newFileName = UUID.randomUUID() + fileName;
        String newFilePath = filePath + newFileName;
        try {
            // 将图片存到制定的位置
            multipartFile.transferTo(new File(newFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product();
        product.setUsername(request.getParameter("name"));
        product.setQq(request.getParameter("qq"));
        product.setTelephone(request.getParameter("tele"));
        product.setImagePath("cloudhouseImage/goods/" + newFileName);
        product.setProductInfo(request.getParameter("Message"));
        product.setReleaseTime(new Date());
        int res = productService.insertProduct(product);
        if(res == 1) {
            return new CommonResult(200, "数据已成功存入数据库");
        } else {
            return new CommonResult(444, "数据未成功存入数据库");
        }
    }
}
