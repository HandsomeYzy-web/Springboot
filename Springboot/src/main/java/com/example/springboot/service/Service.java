package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.mapper.*;
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
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderDetailsMapper orderDetailsMapper;

    public boolean createAddress(Address address) {
        return addressMapper.insert(address) > 0;
    }

    public List<Address> queryAddress(String username) {
        return addressMapper.selectAddress(username);
    }

    public boolean checkUser(User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", user.getUsername()).eq("type", user.getType());
        if (!user.getType().equals("user"))
            userQueryWrapper.eq("password", user.getPassword());
        return userMapper.selectOne(userQueryWrapper) != null;
    }

    public void createUser(User user) {
        userMapper.insert(user);
    }

    public void deleteCarts(String userName) throws SQLException {
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

    public void insertOrder(Order order) throws SQLException {
        orderMapper.insert(order);
    }

    public void insertOrderDetails(OrderDetails[]  orderDetails) throws SQLException{
        for (OrderDetails orderDetail: orderDetails) {
            orderDetailsMapper.insert(orderDetail);
        }
    }
}
