package com.hh.mayipapa.service.impl;


import com.hh.mayipapa.dao.IUserPingTuan;

import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.entity.UserPingTuan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPingTuanService {
    @Autowired
   IUserPingTuan mapper;

    public List<UserPingTuan> getAllUserPingTuan(String pname){
        return mapper.selectAllUserPingTuan();
    }
}
