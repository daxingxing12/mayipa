package com.hh.mayipapa.dao;

import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.entity.UserPingTuan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface IUserPingTuan {
    @Select("select * from users_pingtuan where pname = #{pname}")
    List<UserPingTuan> getAllUserPingTuan(String pname);


    List<UserPingTuan> selectAllUserPingTuan();
}
