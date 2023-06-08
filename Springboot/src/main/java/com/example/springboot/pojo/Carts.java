package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("carts")
public class Carts {
    private String userName;
    private Integer menu_id;
    private Integer quantity;
}
