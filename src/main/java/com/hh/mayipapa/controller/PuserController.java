package com.hh.mayipapa.controller;

import com.hh.mayipapa.entity.Puser;
import com.hh.mayipapa.service.impl.PuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PuserController {
    @Autowired
    PuserService  puserService;
    @PostMapping("checkLogin")
    public ResponseEntity<Object> checkLogin(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("pname");
        String password = credentials.get("ppassword");

        // 假设puserService.checkLogin接收用户名和密码，并返回匹配的用户信息或null
        String psd = puserService.checkLogin(username);

        if (psd != password) {
            // 登录成功，可以返回token或其他认证信息
            // 这里只是一个示例，您应该根据您的应用逻辑生成和返回token
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("success", true);
            successResponse.put("token", "your_generated_token"); // 替换为您的token生成逻辑
            return ResponseEntity.ok(successResponse);
        } else {
            // 登录失败
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "用户名或密码错误");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
    @PostMapping("register")
    public ResponseEntity<Object> register(@RequestBody Puser puser) {
        if(puserService.checkLogin(puser.getPname())!=null){
            return ResponseEntity.badRequest().body("用户名已存在");
        }
        else{
            int result = puserService.save(puser);
            // 根据result的值返回相应的HTTP响应
            if (result > 0) {
                return ResponseEntity.ok("用户注册成功");
            } else {
                return ResponseEntity.badRequest().body("用户注册失败");
            }
        }
    }
}
