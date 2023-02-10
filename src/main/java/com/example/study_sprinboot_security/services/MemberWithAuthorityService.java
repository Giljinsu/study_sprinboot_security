package com.example.study_sprinboot_security.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.study_sprinboot_security.daos.SharedDao;
import com.example.study_sprinboot_security.utils.CommonUtils;

@Service
public class MemberWithAuthorityService {
    @Autowired
    SharedDao sharedDao;

    @Autowired
    CommonUtils commonUtils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Object insert(Object dataMap) {
        // BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        ((Map)dataMap).put("USERS_UID", commonUtils.getUniqueSequence());
        ((Map)dataMap).put("role", "ROLE_USER");
        //normal to crypto password
        String Password = (String)((Map)dataMap).get("password");
        ((Map)dataMap).put("password", bCryptPasswordEncoder.encode(Password));
        
        String sqlMapId = "Memberwithauthority.insertWithUID";
        Object result= sharedDao.insertOne(sqlMapId, dataMap);
        return result;
    }
}
