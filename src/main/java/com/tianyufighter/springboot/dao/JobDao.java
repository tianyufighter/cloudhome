package com.tianyufighter.springboot.dao;

import com.tianyufighter.springboot.domain.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobDao {
    // 向数据库中存入一条兼职消息
    int insertJob(Job job);
    // 查询数据库中所有的兼职信息
    List<Job> queryAllJob();
}
