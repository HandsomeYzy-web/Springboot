package com.example.springboot.controller;

import com.example.springboot.pojo.Address;
import com.example.springboot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    Service service;
    @PostMapping("/add")
    public ResponseEntity<Object> Addinfo(@RequestBody Address address){
        if(service.insertInfo(address)){
            return ResponseEntity.ok("ok");
        }
        else {
            return ResponseEntity.status(400).body("error");
        }
    }
    @GetMapping("/select")
    public List<Address> search(String username){
        return service.searchInfo(username);
    }
}
