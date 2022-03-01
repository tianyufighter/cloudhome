package com.tianyufighter.springboot.controller.job;

import com.github.pagehelper.PageInfo;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.Job;
import com.tianyufighter.springboot.domain.Product;
import com.tianyufighter.springboot.service.job.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class QueryJobByPage {
    @Autowired
    private JobService jobService;
    @RequestMapping("/queryJobByPage")
    public CommonResult<PageInfo<Job>> queryJobByPage(HttpServletRequest request) {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        PageInfo<Job> pageInfo = jobService.queryAllInfoByPage(pageNum, pageSize);
        if(pageInfo != null) {
            System.out.println("成功找到");
            return new CommonResult<PageInfo<Job>>(200, "在数据库中成功找到请求数据", pageInfo);
        } else {
            System.out.println("未成功找到");
            return new CommonResult<PageInfo<Job>>(444, "未在数据库中找到请求数据", pageInfo);
        }
    }
}
