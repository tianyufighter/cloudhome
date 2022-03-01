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
public class Lostgood {
    private int id;
    private String username;
    private String content;
    private Date releaseTime;
    private String location;
    private String imagePath;
}
