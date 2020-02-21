package com.zcd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zcd
 * @description:
 * @create 2020/2/20 20:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private int id;
    private String name;
    private String logo;
    private String description;
    private String price;
    private String type;
    private String recommend;
}
