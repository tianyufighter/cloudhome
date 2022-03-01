package com.tianyufighter.springboot.controller.user;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.User;
import com.tianyufighter.springboot.service.user.UserService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@RestController
@Slf4j
public class StoreUserInfo {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/storeInfo", method = RequestMethod.POST)
    public CommonResult storeInfo(HttpServletRequest request) {
        System.out.println("接收到来自客户端的请求");
        // 获取上传的文件
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
        MultipartFile multipartFile = multipartRequest.getFile("headImage");
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        // 文件保存路径
        String filePath = "/opt/cloudhouse/cloudhouseImage/head/";
        System.out.println("reuqest=" + request.getServletContext().getRealPath("static"));
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
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setIntroduce(request.getParameter("introduce"));
        user.setGender(Boolean.valueOf(request.getParameter("gender")));
        user.setRealName(request.getParameter("realName"));
        user.setHeadImage("cloudhouseImage/head/" + newFileName);
        System.out.println("newFileName: " + newFileName);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(format.parse(request.getParameter("birthday")));
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        // 将用户信息存储数据库
        int res = userService.updateSelfInfo(user);
        if(res == 1) {
            return new CommonResult(200, "数据存储成功");
        } else {
            System.out.println("数据存储失败");
            return new CommonResult(444, "数据存储失败");
        }
    }
}
