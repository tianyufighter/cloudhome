package com.tianyufighter.springboot.service.job.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianyufighter.springboot.dao.JobDao;
import com.tianyufighter.springboot.domain.Job;
import com.tianyufighter.springboot.service.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;
    @Override
    public int insertJobInfo(Job job) {
        return jobDao.insertJob(job);
    }

    @Override
    public List<Job> queryAllInfo() {
        return jobDao.queryAllJob();
    }

    @Override
    public PageInfo<Job> queryAllInfoByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Job> lists = jobDao.queryAllJob();
        PageInfo<Job> pageInfo = new PageInfo<Job>(lists);
        return pageInfo;
    }
}
