package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("menu")
public class Menu {
    private Integer id;
    private String name;
    private String label;
    private Integer price;
    private String intro;
    private String raw;
    private String image;
}
