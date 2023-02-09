package com.example.study_sprinboot_security.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.study_sprinboot_security.daos.SharedDao;

public class MemberWithAuthorityService {
    @Autowired
    SharedDao sharedDao;

    public Object insert(Object dataMap) {
        String sqlMapId = "Memberwithauthority.insertWithUID";
        Object result= sharedDao.insertOne(sqlMapId, dataMap);
        return result;
    }
}
