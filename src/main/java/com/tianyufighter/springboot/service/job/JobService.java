package com.tianyufighter.springboot.service.job;

import com.github.pagehelper.PageInfo;
import com.tianyufighter.springboot.domain.Job;

import java.util.List;

public interface JobService {
    /**
     * 向数据库中插入一条兼职信息
     */
    int insertJobInfo(Job job);
    /**
     * 查询数据库中所有的兼职信息
     */
    List<Job> queryAllInfo();
    PageInfo<Job> queryAllInfoByPage(int pageNum, int pageSize);
}
