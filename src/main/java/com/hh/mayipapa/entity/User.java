package com.hh.mayipapa.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private int tid;
    private String origin;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String GuideName;
    private int NumberOfPeople;
    private String publisher;
    private String cost;
    private String img;
    private String TouristGroupName;
    private String pname;
    private String detail;
    private String GuideStatus;
}
