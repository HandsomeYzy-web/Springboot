package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order")
public class Order {
    private String username;
    private String orderNum;
    private String orderTime;
    private Integer totalPrice;
    private String phoneNum;
    private String name;
    private String address;
}
