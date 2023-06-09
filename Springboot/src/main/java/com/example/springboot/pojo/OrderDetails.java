package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orderdetails")
public class OrderDetails {
    private String orderNum;
    private Integer menuId;
    private Integer quantity;
}
