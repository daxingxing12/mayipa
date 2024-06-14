package com.hh.mayipapa.service.impl;

import com.hh.mayipapa.dao.IGroupMapper;
import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.entity.UserGroup;
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



    @Override
    public int insertGroup(Group group){return mapper.insertGroup(group);}

    @Override
    public List<Group> selectByGuideId(String sid){return mapper.selectByGuideId(sid);}
    @Override
    public Group selectByTid(String tid){return mapper.selectByTid(tid);}

    @Override
    public int insertUserGroup(UserGroup userGroup){return mapper.insertUserGroup(userGroup);}

    @Override
    public int updateGroup(String value,String tid){return mapper.updateGroupStatus(value,tid);};


}
