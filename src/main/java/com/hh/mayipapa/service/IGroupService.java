package com.hh.mayipapa.service;

import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.entity.UserGroup;

import java.util.List;

public interface IGroupService {
    List<Group> getAllGroup();

    int insertGroup(Group group);
    List<Group> selectByGuideId(String sid);
    Group selectByTid(String tid);
    int insertUserGroup(UserGroup userGroup);
    int updateGroup(String group,String tid);

}
