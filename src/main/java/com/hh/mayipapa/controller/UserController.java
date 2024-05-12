package com.hh.mayipapa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/nihao")
    public String hi(){
        return "hi";
    }

}
