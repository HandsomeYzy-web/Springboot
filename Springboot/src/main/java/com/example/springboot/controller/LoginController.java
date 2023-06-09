package com.example.springboot.controller;

import com.example.springboot.pojo.User;
import com.example.springboot.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
public class LoginController {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    Service service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(summary = "用户登录")
    public ResponseEntity<Objects> login(@RequestBody User user) {
        if (user.getType().equals("user")) {
            if (!service.checkUser(user)) {
                user.setPassword(null);
                service.createUser(user);
            }
            return ResponseEntity.ok().build();
        } else {
            if (service.checkUser(user)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(404).build();
            }
        }
    }
}