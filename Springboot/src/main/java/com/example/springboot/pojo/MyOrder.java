package com.example.springboot.pojo;

import lombok.Data;

@Data
public class MyOrder {
    private String username;
    private String orderNum;
    private String orderTime;
    private Integer totalPrice;
    private String phoneNum;
    private String name;
    private String address;
    private Integer status;
    private Integer menuId;
    private Integer quantity;
    private String menuName;
    private Integer price;
}
