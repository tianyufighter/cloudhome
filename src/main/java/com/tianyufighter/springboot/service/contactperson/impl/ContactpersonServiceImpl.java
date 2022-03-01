package com.tianyufighter.springboot.service.contactperson.impl;

import com.tianyufighter.springboot.dao.ContactpersonDao;
import com.tianyufighter.springboot.domain.Contactperson;
import com.tianyufighter.springboot.service.contactperson.ContactpersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactpersonServiceImpl implements ContactpersonService {
    @Autowired
    private ContactpersonDao contactpersonDao;
    @Override
    public int insertPerson(Contactperson contactperson) {
        return contactpersonDao.insertPerson(contactperson);
    }

    @Override
    public List<Contactperson> queryPerson(String username) {
        return contactpersonDao.queryPerson(username);
    }

    @Override
    public Contactperson isContactPerson(String username, String toUsername) {
        return contactpersonDao.queryPersonByName(username, toUsername);
    }

    @Override
    public int deleteLiaison(String username, String toUsername) {
        return contactpersonDao.deleteLiaison(username, toUsername);
    }
}
