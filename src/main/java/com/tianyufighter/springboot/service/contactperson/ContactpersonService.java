package com.tianyufighter.springboot.service.contactperson;

import com.tianyufighter.springboot.domain.Contactperson;

import java.util.List;

/**
 * 对用户好友信息的操作
 */
public interface ContactpersonService {
    int insertPerson(Contactperson contactperson);
    List<Contactperson> queryPerson(String username);
    /**
     * 查询数据库种中是否有该对联系人
     */
    Contactperson isContactPerson(String username, String toUsername);
    /**
     * 根据名字删除联系人
     */
    int deleteLiaison(String username, String toUsername);
}
