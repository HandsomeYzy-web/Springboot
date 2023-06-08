package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@TableName("address")
public class Address {
    private String username;
    private String number;
    private String name;
    private String address;
}
