package com.hh.mayipapa.dao;

import com.hh.mayipapa.entity.Group;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IGroupMapper {
    @Select("select * from touristgroup")
    List<Group> selectAllGroup();

    @Insert("INSERT INTO touristgroup (GuideName, GuidId, EndTime, StartTime, origin, publisher, " +
            "ReleaseTime, deadline, NumberOfPeople, cost, tid) " +
            "VALUES (#{guideName}, #{guidId}, #{endTime}, #{startTime}, #{origin}, #{publisher}, " +
            "#{releaseTime}, #{deadline}, #{numberOfPeople}, #{cost}, #{tid})")
    int insertGroup(Group group);
}
