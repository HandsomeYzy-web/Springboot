package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.mapper.*;
import com.example.springboot.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
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
    @Autowired
    ReceiveMapper receiveMapper;

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

    public List<Order> getOrder(String delivery) {
        return orderMapper.selectOrder(delivery);
    }

    public List<Order> getOrders() {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 0);
        return orderMapper.selectList(wrapper);
    }


    public boolean checkOrder(Receive receive) {
        return receiveMapper.insert(receive) > 0;
    }

    public boolean setStatus(String orderNum, int status) {
        Order order = orderMapper.selectById(orderNum);
        order.setStatus(status);
        return orderMapper.updateById(order) > 0;
    }

    public boolean queryReceive(String orderNum) {
        return receiveMapper.selectById(orderNum) != null;
    }

    public void deleteReceive(Receive receive) {
        receiveMapper.deleteById(receive);
    }

    public List<MyOrder> getMyOrder(String username){
        return orderMapper.selectMyOrder(username);
    }
}
