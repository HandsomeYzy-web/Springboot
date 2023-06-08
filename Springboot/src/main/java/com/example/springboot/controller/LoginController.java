package com.example.springboot.controller;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.pojo.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Objects;


@RestController
public class LoginController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(summary = "用户登录")
    public ResponseEntity<Objects> login(@RequestBody User user) {
        Connection conn = null;
        try {
            // 建立数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/takeaway", "root", "111111");

            if (user.getType().equals("user")) {
                String query = "select username from user where username=? and type = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getType());

                ResultSet resultSet = statement.executeQuery();

                if (!resultSet.next()) {
                    String sql = "insert into user values (?,?,null)";
                    statement = conn.prepareStatement(sql);
                    statement.setString(1, user.getUsername());
                    System.out.println(user.getUsername());
                    statement.setString(2, user.getType());
                    statement.executeUpdate();
                }
                return ResponseEntity.ok().build();
            } else {
                String query = "select * from user where userName = ? and type = ? and password = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getType());
                statement.setString(3, user.getPassword());

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.status(404).build();
                }
            }

            // 关闭连接和资源
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        } finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

