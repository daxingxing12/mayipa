package com.hh.mayipapa.dao;

import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.entity.ProblemFeedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IProblemFeedback {

    @Insert("insert into problemfeedback(username, FeedbackContent, FeedbackTime, FeedbackStatus) values(#{username}, #{FeedbackContent}, #{FeedbackTime}, #{FeedbackStatus})")
    int insertproblemfeedback(ProblemFeedback problemfeedback);
    @Select("select * from problemfeedback")
    List<ProblemFeedback> getAllProblemFeedback();
}
