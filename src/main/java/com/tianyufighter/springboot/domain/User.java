package com.tianyufighter.springboot.domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String username;
    private String password;
    private String introduce;
    private Boolean gender;
    private String realName;
    private Date birthday;
    private String headImage;
}
