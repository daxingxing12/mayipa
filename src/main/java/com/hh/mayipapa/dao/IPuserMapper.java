package com.hh.mayipapa.dao;

import com.hh.mayipapa.entity.Puser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IPuserMapper {
    @Select("SELECT ppassword FROM pusers WHERE pname = #{pname}")
    String checkLogin(String pname);

    @Insert("INSERT INTO pusers (pname, phone, address, identify, age, ppassword) " +
            "VALUES (#{pname}, #{phone}, #{address}, #{identify}, #{age}, #{ppassword})")
    int insertPuser(Puser puser);
}

