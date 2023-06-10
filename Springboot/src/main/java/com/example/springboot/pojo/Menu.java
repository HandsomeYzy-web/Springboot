package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@TableName("menu")
public class Menu {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String label;
    private Integer price;
    private String intro;
    private String raw;
    private String image;
}
