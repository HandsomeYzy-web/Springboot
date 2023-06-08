package com.example.springboot.pojo;

import lombok.Data;

@Data
public class settleCarts {
    private Integer menu_id;
    private Integer quantity;
    private String name;
    private Integer price;
    private String image;
}
