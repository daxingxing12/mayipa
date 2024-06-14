package com.hh.mayipapa.controller;

import com.hh.mayipapa.dao.IGroupMapper;
import com.hh.mayipapa.entity.Group;
import com.hh.mayipapa.entity.Suser;
import com.hh.mayipapa.entity.UserGroup;
import com.hh.mayipapa.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        group.setGuidId(credentials.getOrDefault("GuideId", null));
        group.setEndTime(credentials.getOrDefault("EndTime", null));
        group.setStartTime(credentials.getOrDefault("StartTime", null));
        group.setOrigin(credentials.getOrDefault("origin", null));
        group.setPublisher(credentials.getOrDefault("publisher", null));
        group.setReleaseTime(credentials.getOrDefault("ReleaseTime", null));
        group.setDeadline(credentials.getOrDefault("deadline", null));
        group.setNumberOfPeople(credentials.getOrDefault("NumberOfPeople", null));
        group.setCost(credentials.getOrDefault("cost", null));


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String currentTime = sdf.format(new Date());
        String tid = currentTime;
        // ... 为其他字段做相同的映射
        group.setTid(tid);
        group.setGuideStatus("否");
        group.setStatus("否");

        int a=groupservice.insertGroup(group);

        // 根据需要返回响应
        if (a > 0) {
            return ResponseEntity.ok("已发布，等待审核");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("发布失败");
        }
    }

    @PostMapping("invite")
    public List<Group> invite(@RequestBody Map<String, String> credentials){
//        Suser s=new Suser();
//        s.getSid(credentials.getOrDefault("sid", null));
        return groupservice.selectByGuideId(credentials.getOrDefault("sid", null));
        }

    @PostMapping("detail")
    public Group detail(@RequestBody TidRequest tidRequest){
        String tid = tidRequest.getTid();
        return groupservice.selectByTid(tid);
    }
    @PostMapping("reserve")
    public ResponseEntity<?> reserve(@RequestBody UserGroup userGroup) {
        try {
            int status = groupservice.insertUserGroup(userGroup);
            if (status != 0) {
                return ResponseEntity.ok("预定成功");
            } else {
                // 如果 service 返回 0 表示插入失败，但通常 service 应该抛出异常
                return ResponseEntity.badRequest().body("预定失败：内部错误");
            }
        } catch (DataAccessException e) { // 捕获 Spring 数据访问异常
            // 检查异常是否是由于数据完整性约束违反（如主键冲突）
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                return ResponseEntity.badRequest().body("预定失败：该团组已存在");
            } else {
                // 处理其他可能的数据访问异常
                return ResponseEntity.badRequest().body("预定失败：内部数据库错误");
            }
        } catch (Exception e) { // 捕获其他未预期的异常
            // 适当的错误日志和可能的回退处理
            return ResponseEntity.badRequest().body("预定失败：未知错误");
        }
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody Map<String, String> credentials) {
        Group group = new Group(); // 假设Group是您的实体类

        // 手动从credentials Map中映射数据到Group对象
        group.setGuideStatus(credentials.getOrDefault("value", null));
        group.setTid(credentials.getOrDefault("tid", null));


        int status = groupservice.updateGroup(group.getGuideStatus(),group.getTid());
        if (status != 0) {
            return ResponseEntity.ok("更新成功");
        } else {
            // 如果 service 返回 0 表示更新失败，但通常 service 应该抛出异常
            return ResponseEntity.badRequest().body("更新失败：内部错误");
        }
    }
    }