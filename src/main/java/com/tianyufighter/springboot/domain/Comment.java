package com.tianyufighter.springboot.domain;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private int id;
    private String username;
    private int tieziId;
    private Date commentTime;
    private String content;
}
