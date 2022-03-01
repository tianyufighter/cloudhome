package com.tianyufighter.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chat {
    private int id;
    private String username;
    private String toUsername;
    private String imagePath;
    private String message;
    private Date infoTime;
    private Boolean isComplete;
    private String usernameImage;
}
