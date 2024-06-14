package com.hh.mayipapa.controller;

import com.hh.mayipapa.dao.IUserPingTuan;
import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.entity.UserPingTuan;
import com.hh.mayipapa.service.impl.UserPingTuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserPingTuanController {
    @Autowired
    IUserPingTuan userpingtuanservice;

    @RequestMapping("userpingtuan")
    public ResponseEntity<Object> checkLogin(@RequestBody Map<String, String> credentials) {
        String pname1 = credentials.get("pname");
        Object data = userpingtuanservice.getAllUserPingTuan(pname1);
        return new ResponseEntity<>(data, HttpStatus.OK);

    }
    @RequestMapping("userpingtuan1")
    public List<UserPingTuan> allGroup(){
        return  userpingtuanservice.getAllUserPingTuan("张三");
    }
}
