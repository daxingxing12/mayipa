package com.hh.mayipapa.dao;

import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.entity.UserGroup;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface IGroupMapper {
    @Select("select * from touristgroup")
    List<Group> selectAllGroup();

    @Insert("INSERT INTO touristgroup (tid, pid,origin, StartTime, EndTime, GuideName, NumberOfPeople, GuideId, " +
            "publisher, ReleaseTime, deadline, cost, img, status, GuideStatus ) VALUES (" +
            "#{tid},#{pid}, #{origin}, #{startTime}, #{endTime}, #{guideName}, #{numberOfPeople}, #{guidId}, #{publisher}, " +
            "#{releaseTime}, #{deadline}, #{cost}, #{img}, #{status}, #{guideStatus} )")
    int insertGroup(Group group);

    @Select("select * from touristgroup where guideId = #{sid}")
    List<Group> selectByGuideId(String sid);
    @Select("select * from touristgroup where tid = #{tid}")
    Group selectByTid(String tid);

    @Insert("INSERT INTO users_pingtuan (pname, tid, TouristGroupName) VALUES (#{pname}, #{tid}, #{touristGroupName})")
    int insertUserGroup(UserGroup userGroup);
    //修改数据库touristgroup里guidestatus的值为前端传来的值
    @Update("update touristgroup set guideStatus = #{value} where tid = #{tid}")
    int updateGroupStatus(String value,String tid);
}
