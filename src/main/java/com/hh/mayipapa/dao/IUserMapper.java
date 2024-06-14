package com.hh.mayipapa.dao;

import com.hh.mayipapa.entity.Contest;
import com.hh.mayipapa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IUserMapper {
    @Select("select * from touristgroup")
    List<User> selectAllUsers();


    Contest selectContestsByID(int tid);
}
