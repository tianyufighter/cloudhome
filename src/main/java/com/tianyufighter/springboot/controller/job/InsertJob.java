package com.tianyufighter.springboot.controller.job;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.Job;
import com.tianyufighter.springboot.service.job.JobService;
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
public class InsertJob {
    @Autowired
    private JobService jobService;

    @RequestMapping("/insertOneJob")
    public CommonResult insertJob(HttpServletRequest request) {
        // 获取上传的文件
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
        MultipartFile multipartFile = multipartRequest.getFile("photo");
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        String newFileName = "";
        if(fileName != null && fileName != "") {
            // 文件保存路径
            String filePath = "/opt/cloudhouse/cloudhouseImage/jianzhi/";
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
        Job job = new Job();
        if(fileName != null && fileName != "") {
            job.setPhoto("cloudhouseImage/jianzhi/" + newFileName);
        }
        job.setUsername(request.getParameter("username"));
        job.setPhone(request.getParameter("phone"));
        job.setAddress(request.getParameter("address"));
        job.setTitle(request.getParameter("title"));
        job.setContent(request.getParameter("content"));
        job.setReleaseTime(new Date());
        // 向数据库中插入消息
        int res = jobService.insertJobInfo(job);
        if(res == 1) {
            System.out.println("数据库插入成功");
            return new CommonResult(200, "数据已成功插入数据库");
        } else {
            System.out.println("数据库插入失败");
            return new CommonResult(444, "数据插入数据库失败");
        }
    }
}
