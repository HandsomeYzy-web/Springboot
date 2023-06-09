package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.mapper.AddressMapper;
import com.example.springboot.mapper.CartsMapper;
import com.example.springboot.mapper.MenuMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    AddressMapper addressMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CartsMapper cartsMapper;
    @Autowired
    MenuMapper menuMapper;

    public boolean createAddress(Address address) {
        return addressMapper.insert(address) > 0;
    }

    public List<Address> queryAddress(String username) {
        return addressMapper.select666(username);
    }

    public boolean checkUser(User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", user.getUsername()).eq("type", "user");
        return userMapper.selectOne(userQueryWrapper) != null;
    }

    public void createUser(User user) {
        userMapper.insert(user);
    }

    public void deleteCarts(String userName) {
        cartsMapper.deleteById(userName);
    }

    public void insertCarts(Carts[] carts) throws SQLException {
        for (Carts cart : carts) {
            cartsMapper.insert(cart);
        }
    }

    public List<settleCarts> querySettleCarts(String userName) throws SQLException {
        return cartsMapper.selectSettle(userName);
    }

    public List<Menu> queryMenu() throws SQLException {
        return menuMapper.selectList(null);
    }
}
