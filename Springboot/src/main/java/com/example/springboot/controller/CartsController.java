package com.example.springboot.controller;

import com.example.springboot.pojo.Carts;
import com.example.springboot.pojo.settleCarts;
import com.example.springboot.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CartsController {
    @Autowired
    Service service;

    @RequestMapping(value = "/settleCarts", method = RequestMethod.POST)
    @Operation(summary = "购物车存储")
    public ResponseEntity<Void> settleCarts(@RequestBody Carts[] carts) {
        try {
            service.deleteCarts(carts[1].getUserName());
            service.insertCarts(carts);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

    @RequestMapping(value = "/getCarts", method = RequestMethod.GET)
    @Operation(summary = "购物车获取")
    public ResponseEntity<List<settleCarts>> getCarts(@RequestParam("userName") String userName) {
        try {
            List<settleCarts> cartsList;
            cartsList = service.querySettleCarts(userName);
            return ResponseEntity.ok(cartsList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
}
