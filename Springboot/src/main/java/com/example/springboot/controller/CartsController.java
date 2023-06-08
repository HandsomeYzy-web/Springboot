package com.example.springboot.controller;

import com.example.springboot.mapper.CartsMapper;
import com.example.springboot.mapper.SettleCartsMapper;
import com.example.springboot.pojo.Carts;
import com.example.springboot.pojo.settleCarts;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartsController {
    @Autowired
    CartsMapper cartsMapper;

    @RequestMapping(value = "/settleCarts", method = RequestMethod.POST)
    @Operation(summary = "购物车存储")
    public ResponseEntity<Void> settleCarts(@RequestBody Carts[] carts) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/takeaway", "root", "111111");

            String query = "select * from carts where userName = ? and menu_id = ?";
            String sql1 = "update carts set quantity = ? where userName = ? and menu_id = ?";
            String sql2 = "insert into carts (userName, menu_id, quantity) values (?, ?, ?)";
            PreparedStatement statement;

            for (Carts cart : carts) {
                statement = conn.prepareStatement(query);
                statement.setString(1, cart.getUserName());
                statement.setInt(2, cart.getMenu_id());

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    statement = conn.prepareStatement(sql1);
                    statement.setInt(1, cart.getQuantity());
                    statement.setString(2, cart.getUserName());
                    statement.setInt(3, cart.getMenu_id());

                    statement.executeUpdate();
                } else {
                    statement = conn.prepareStatement(sql2);
                    statement.setString(1, cart.getUserName());
                    statement.setInt(2, cart.getMenu_id());
                    statement.setInt(3, cart.getQuantity());

                    statement.executeUpdate();
                }
            }

            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Autowired
    SettleCartsMapper settleCartsMapper;

    @RequestMapping(value = "/getCarts", method = RequestMethod.GET)
    @Operation(summary = "购物车获取")
    public ResponseEntity<List<settleCarts>> getCarts(@RequestParam("userName") String userName) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/takeaway", "root", "111111");
            List<settleCarts> cartsList = new ArrayList<>();

            String query = "select menu_id,quantity,name,price,image from carts,menu where carts.menu_id = menu.id and userName = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, userName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                settleCarts cartItem = new settleCarts();
                cartItem.setMenu_id(resultSet.getInt("menu_id"));
                cartItem.setQuantity(resultSet.getInt("quantity"));
                cartItem.setName(resultSet.getString("name"));
                cartItem.setPrice(resultSet.getInt("price"));
                cartItem.setImage(resultSet.getString("image"));

                cartsList.add(cartItem);
            }
                return ResponseEntity.ok(cartsList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
