package com.tianyufighter.springboot.dao;

import com.tianyufighter.springboot.domain.Contactperson;
import com.tianyufighter.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactpersonDao {
    /**
     * 插入联系人
     * @return 影响的行数
     */
    int insertPerson(Contactperson contactperson);

    /**
     * 根据用户名查询该用户名所有的联系人
     * @param username 用户名
     * @return 返回的结果
     */
    List<Contactperson> queryPerson(@Param("master") String username);

    /**
     * 查询数据库中是否已有联系人的消息
     */
    Contactperson queryPersonByName(@Param("master") String username, @Param("friend") String toUsername);
    /**
     * 根据联系人双方的名称删除信息
     */
    int deleteLiaison(@Param("master") String username, @Param("friend") String toUsername);
}
