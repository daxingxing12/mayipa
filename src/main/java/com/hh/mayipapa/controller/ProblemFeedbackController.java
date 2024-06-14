package com.hh.mayipapa.controller;

import com.hh.mayipapa.dao.IProblemFeedback;
import com.hh.mayipapa.entity.ProblemFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class ProblemFeedbackController {
    @Autowired
    IProblemFeedback ProblemFeedbackService;
    @RequestMapping("feedback")
    public ResponseEntity<Object> checkLogin(@RequestBody Map<String, String> credentials) {
        String pname1 = credentials.get("username");
        String FeedbackContent1 = credentials.get("FeedbackContent");
        // 创建一个DateTimeFormatter对象，用于格式化LocalDateTime为String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 获取当前时间
        LocalDateTime feedbackTime = LocalDateTime.now();

        // 将LocalDateTime转换为String
        String feedbackTimeStr = feedbackTime.format(formatter);
        // 设置反馈状态为“未处理”
        String FeedbackStatus = "未处理";
        // 创建ProblemFeedback对象并设置属性
        ProblemFeedback problemFeedback = new ProblemFeedback();
        problemFeedback.setUsername(pname1);
        problemFeedback.setFeedbackContent(FeedbackContent1);
        problemFeedback.setFeedbackTime(feedbackTimeStr);
        problemFeedback.setFeedbackStatus(FeedbackStatus);

        // 调用Service的方法插入数据到数据库
        ProblemFeedbackService.insertproblemfeedback(problemFeedback);

        // 返回成功的响应
        return new ResponseEntity<>("Feedback submitted successfully", HttpStatus.OK);

    }


}
