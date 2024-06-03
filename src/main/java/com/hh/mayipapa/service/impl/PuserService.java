package com.hh.mayipapa.service.impl;

import com.hh.mayipapa.dao.IPuserMapper;
import com.hh.mayipapa.entity.Puser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuserService {
    @Autowired
    IPuserMapper mapper;
    public String checkLogin(String pname) {
        return mapper.checkLogin(pname);
    }
    public int save(Puser puser){
        return mapper.insertPuser(puser);
    }
}
