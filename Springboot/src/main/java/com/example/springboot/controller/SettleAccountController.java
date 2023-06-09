package com.example.springboot.controller;

import com.example.springboot.pojo.Order;
import com.example.springboot.pojo.OrderDetails;
import com.example.springboot.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class SettleAccountController {
    @Autowired
    Service service;

    @RequestMapping(value = "/deleteCarts", method = RequestMethod.DELETE)
    @Operation(summary = "删除购物车")
    public ResponseEntity<Object> deleteCarts(@RequestParam String username){
        try {
            service.deleteCarts(username);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }

    @RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
    @Operation(summary = "插入订单表")
    public ResponseEntity<Object> insertOrder (@RequestBody Order order){
        try {
            service.insertOrder(order);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }

    @RequestMapping(value = "/insertOrderDetails", method = RequestMethod.POST)
    @Operation(summary = "插入订单详表")
    public ResponseEntity<Object> insertOrderDetails (@RequestBody OrderDetails[] orderDetails){
        try {
            service.insertOrderDetails(orderDetails);
            return ResponseEntity.ok().build();
        } catch (SQLException e){
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }
}
