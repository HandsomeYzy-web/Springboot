package com.example.springboot.controller;

import com.example.springboot.pojo.Menu;
import com.example.springboot.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    Service service;

    @RequestMapping(value = "/getMenu", method = RequestMethod.GET)
    @Operation(summary = "获取菜单")
    public ResponseEntity<Object> getMenu() {
        Connection conn = null;
        try {

            List<Menu> menuList = new ArrayList<>();
            menuList = service.queryMenu();

            if (menuList.isEmpty()) {
                return ResponseEntity.status(404).build();
            } else {
                return ResponseEntity.ok(menuList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
}