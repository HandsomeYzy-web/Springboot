package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("carts")
public class Carts {
    @TableId("userName")
    private String userName;

    @TableField("menu_id")
    private Integer menuId;

    private Integer quantity;
}
