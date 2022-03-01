package com.tianyufighter.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {
    private int id;
    private String username;
    private String phone;
    private String address;
    private String photo;
    private String title;
    private String content;
    private Date releaseTime;
}
