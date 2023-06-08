package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private String username;
    private String password;

    private String type;

}
