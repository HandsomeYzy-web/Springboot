package com.example.springboot.pojo;

import lombok.Data;

@Data
public class settleCarts {
    private Integer menuId;
    private Integer quantity;
    private String name;
    private Integer price;
    private String image;
}
