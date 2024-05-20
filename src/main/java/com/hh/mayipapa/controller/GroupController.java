package com.hh.mayipapa.controller;

import com.hh.mayipapa.dao.IGroupMapper;
import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GroupController {
    @Autowired
    IGroupService groupservice;

    @RequestMapping("groups")
    public List<Group> allGroup(){
        return  groupservice.getAllGroup();
    }

    @PostMapping("insertGroup")
    public ResponseEntity<String> insertGroup(@RequestBody Map<String, String> credentials) {
        Group group = new Group(); // 假设Group是您的实体类

        // 手动从credentials Map中映射数据到Group对象
        group.setGuideName(credentials.getOrDefault("GuideName", null));
        group.setGuidId(credentials.getOrDefault("GuidId", null));
        group.setEndTime(credentials.getOrDefault("EndTime", null));
        group.setStartTime(credentials.getOrDefault("StartTime", null));
        group.setOrigin(credentials.getOrDefault("origin", null));
        group.setPublisher(credentials.getOrDefault("publisher", null));
        group.setReleaseTime(credentials.getOrDefault("ReleaseTime", null));
        group.setDeadline(credentials.getOrDefault("deadline", null));
        group.setNumberOfPeople(credentials.getOrDefault("NumberOfPeople", null));
        group.setCost(credentials.getOrDefault("cost", null));
        try {
            group.setTid(Integer.parseInt(credentials.getOrDefault("tid", "0"))); // 假设tid可以为0或者从请求体中获取
        } catch (NumberFormatException e) {
            // 处理异常，例如返回错误响应
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid tid format: " + e.getMessage());
        }
        // ... 为其他字段做相同的映射

        int a=groupservice.insertGroup(group);

        // 根据需要返回响应
        if (a > 0) {
            return ResponseEntity.ok("Group inserted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert group.");
        }
    }
}
