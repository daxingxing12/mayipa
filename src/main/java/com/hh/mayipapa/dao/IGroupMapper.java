package com.hh.mayipapa.dao;

import com.hh.mayipapa.entity.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IGroupMapper {
    @Select("select * from touristgroup")
    List<Group> selectAllGroup();
}
