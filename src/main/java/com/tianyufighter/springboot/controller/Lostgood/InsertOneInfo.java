package com.tianyufighter.springboot.controller.Lostgood;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.Lostgood;
import com.tianyufighter.springboot.service.lostgood.LostgoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class InsertOneInfo {
    @Autowired
    private LostgoodService lostgoodService;
    @RequestMapping("/insertOneInfo")
    public CommonResult insertOneInfo(HttpServletRequest request) {
        // 获取上传的文件
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
        MultipartFile multipartFile = multipartRequest.getFile("infoImage");
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        String newFileName = "";
        if(fileName != null && fileName != "") {
            // 文件保存路径
            String filePath = "/opt/cloudhouse/cloudhouseImage/lost/";
            // 判断文件夹是否存在，不存在则创建
            File file = new File(filePath);
            if(!file.exists()) {
                file.mkdirs();
            }
            newFileName = UUID.randomUUID() + fileName;
            String newFilePath = filePath + newFileName;
            try {
                // 将图片存到制定的位置
                multipartFile.transferTo(new File(newFilePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Lostgood lostgood = new Lostgood();
        lostgood.setUsername(request.getParameter("name"));
        lostgood.setContent(request.getParameter("message"));
        lostgood.setReleaseTime(new Date());
        lostgood.setLocation(request.getParameter("address"));
        if(fileName != null && fileName != "") {
            lostgood.setImagePath("cloudhouseImage/lost/" + newFileName);
        }
        int res = lostgoodService.insertOneLostgood(lostgood);
        if(res == 1) {
            return new CommonResult(200, "数据存储成功");
        } else {
            return new CommonResult(444, "数据未成功存入数据库");
        }
    }
}
