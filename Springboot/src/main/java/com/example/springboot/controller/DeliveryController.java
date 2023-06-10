package com.example.springboot.controller;

import com.example.springboot.pojo.Order;
import com.example.springboot.pojo.Receive;
import com.example.springboot.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    Service service;

    @GetMapping("/getOrder")
    @Operation(summary = "获取接单信息", description = "{params:{delivery: this.delivery}}")
    public ResponseEntity<Object> getOrder(@RequestParam String delivery) {
        List<Order> orders;
        orders = service.getOrder(delivery);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/getOrders")
    @Operation(summary = "获取所有未处理订单", description = "无参数")
    public ResponseEntity<Object> getOrders() {
        List<Order> orders;
        orders = service.getOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/checkOrder")
    @Operation(summary = "外卖员接单", description = "{orderNum:this.orderNum,delivery:this.delivery}")
    public ResponseEntity<Object> checkOrder(@RequestBody Receive receive) {
        String orderNum = receive.getOrderNum();
        if (service.queryReceive(orderNum)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("订单已被接取");
        }
        if (service.checkOrder(receive) && service.setStatus(receive.getOrderNum(), 1)) {
            return ResponseEntity.ok("接单成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/checkDeliver")
    @Operation(summary = "确认送到", description = "")
    public ResponseEntity<Object> checkDeliver(@RequestBody Receive receive) {
        service.deleteReceive(receive);
        service.setStatus(receive.getOrderNum(), 2);
        return ResponseEntity.ok("确认成功");
    }

}
