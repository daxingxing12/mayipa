package com.hh.mayipapa.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IPuserMapper {
    @Select("SELECT ppassword FROM pusers WHERE pname = #{pname}")
    String checkLogin(String pname);
}

