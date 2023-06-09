package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@TableName("user")
@Entity
public class User {
    @Id
    private String username;
    private String password;
    private String type;
}
