package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orderdetails")
public class OrderDetails {
    @TableField("orderNum")
    private String orderNum;
    @TableField("menuId")
    private Integer menuId;
    @TableField("quantity")
    private Integer quantity;
}
