package com.hh.mayipapa.controller;

import com.hh.mayipapa.entity.User;
import com.hh.mayipapa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping("/nihao")
    public String hi(){
        return "hello";
    }
    @RequestMapping("/zaijian")
    public String bye(){
        return "bye";
    }
    @RequestMapping("/user")
    public List<User>allUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }
}
