package com.hh.mayipapa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Puser {
    private String pname;
    private String phone;
    private String address;
    private String identify;
    private String age;

    private String ppassword;



    // 省略getter和setter...

}

