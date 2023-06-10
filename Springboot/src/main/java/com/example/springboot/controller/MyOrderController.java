package com.example.springboot.controller;

import com.example.springboot.pojo.MyOrder;
import com.example.springboot.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyOrderController {
    @Autowired
    Service service;
    @GetMapping ("/getMyOrder")
    @Operation(summary = "获取订单信息")
    public ResponseEntity<List<MyOrder>> getMyOrder(@RequestParam String username) {
        List<MyOrder> list = service.getMyOrder(username);
        return ResponseEntity.ok().body(list);
    }

}
