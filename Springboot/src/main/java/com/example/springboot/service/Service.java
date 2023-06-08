package com.example.springboot.service;

import com.example.springboot.mapper.*;
import com.example.springboot.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    AddressMapper addressMapper;
    public boolean insertInfo(Address address){
        return addressMapper.insert(address)>0;
    }
    public List<Address> searchInfo(String username){
        return addressMapper.select666(username);
    }
}
