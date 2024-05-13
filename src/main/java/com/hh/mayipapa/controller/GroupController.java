package com.hh.mayipapa.controller;

import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.service.IAdminService;
import com.hh.mayipapa.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    IGroupService groupservice;

    @RequestMapping("groups")
    public List<Group> allGroup(){
        return  groupservice.getAllGroup();
    }
}
