package com.hh.mayipapa.service.impl;

import com.hh.mayipapa.dao.IGroupMapper;
import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService{
    @Autowired
    IGroupMapper mapper;

    @Override
    public List<Group> getAllGroup(){
        return mapper.selectAllGroup();
    }
}
