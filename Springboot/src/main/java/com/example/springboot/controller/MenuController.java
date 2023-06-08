package com.example.springboot.controller;

import com.example.springboot.mapper.MenuMapper;
import com.example.springboot.pojo.Menu;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class MenuController {
    @Autowired
    MenuMapper menuMapper;

    @RequestMapping(value = "/getMenu", method = RequestMethod.GET)
    @Operation(summary = "获取菜单")
    public ResponseEntity<Object> getMenu() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/takeaway", "root", "111111");

            String query = "select * from menu";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            List<Menu> menuList = new ArrayList<>();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setName(rs.getString("name"));
                menu.setLabel(rs.getString("label"));
                menu.setPrice(rs.getInt("price"));
                menu.setIntro(rs.getString("intro"));
                menu.setRaw(rs.getString("raw"));
                menu.setImage(rs.getString("image"));
                menuList.add(menu);
            }
            if (menuList.isEmpty()) {
                return ResponseEntity.status(404).build();
            } else {
                return ResponseEntity.ok((Object) menuList);
            }
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
