package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orders")
public class Order {
    private String username;
    @TableId("orderNum")
    private String orderNum;
    @TableField("orderTime")
    private String orderTime;
    @TableField("totalPrice")
    private Integer totalPrice;
    @TableField("phoneNum")
    private String phoneNum;
    private String name;
    private String address;
    private Integer status;
}
