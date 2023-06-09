package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@TableName("carts")
public class Carts {
    @Id
    @TableField("userName")
    private String userName;
    private Integer menu_id;
    private Integer quantity;
}
