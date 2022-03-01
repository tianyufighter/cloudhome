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
public class Card {
    private int id;
    private String username;
    private String imgPath;
    private String content;
    private String title;
    private int commentCount;
    private int favoriteCount;
    private boolean outgoing;
    private String note;
    private Date releaseTime;
    private String cardType;
}
