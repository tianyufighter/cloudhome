package com.tianyufighter.springboot.controller.chat;

import com.tianyufighter.springboot.domain.Chat;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.chat.ChatService;
import com.tianyufighter.springboot.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class InsertChat {
    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping("/insertMessage")
    public CommonResult insertMessage(HttpServletRequest request) {
        // 获取上传的文件
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
        MultipartFile multipartFile = multipartRequest.getFile("messageImage");
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        // 文件保存路径
        String filePath = "/opt/cloudhouse/cloudhouseImage/img/";
        // 判断文件夹是否存在，不存在则创建
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();
        }
        String newFileName = UUID.randomUUID() + fileName;
        String newFilePath = filePath + newFileName;
        try {
            multipartFile.transferTo(new File(newFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("FileName = " + fileName);
        String username = request.getParameter("username");
        String toUsername = request.getParameter("toUsername");
//        System.out.println("username = " + username);
//        String imagePath = request.getParameter("messageImage");
//        System.out.println("imagePath = " + imagePath);
        String message = request.getParameter("message");
        String usernameImage = userService.queryUserImage(username);
        Chat chat = new Chat();
        chat.setUsername(username);
        chat.setToUsername(toUsername);
        if(fileName.equals("")) {
            chat.setImagePath(request.getParameter("expression"));
        } else {
            chat.setImagePath("cloudhouseImage/img/" + newFileName);
        }

        chat.setMessage(message);
        chat.setInfoTime(new Date());
        chat.setIsComplete(false);
        chat.setUsernameImage(usernameImage);
        int res = chatService.insertMessage(chat);
        if(res == 1) {
            return new CommonResult(200, "已成功存入数据库");
        } else {
            return new CommonResult(444, "数据未成功存入数据库");
        }
    }
}
