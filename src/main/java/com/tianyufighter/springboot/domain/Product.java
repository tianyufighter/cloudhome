package com.tianyufighter.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 二手商品信息实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String username;
    private String qq;
    private String telephone;
    private String productInfo;
    private String imagePath;
    private Date releaseTime;
}
