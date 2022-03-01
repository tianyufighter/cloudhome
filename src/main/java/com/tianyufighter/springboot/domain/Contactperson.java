package com.tianyufighter.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contactperson {
    private Integer id;
    private String master;
    private String friend;
    private String friendImage;
}
