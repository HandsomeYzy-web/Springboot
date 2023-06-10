package com.example.springboot.controller;

import com.example.springboot.mapper.MenuMapper;
import com.example.springboot.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MenuController2 {
    @Autowired
    MenuMapper menuMapper;
    @GetMapping("/menu")
    public List<Menu> getMenu(){  return menuMapper.selectList(null); }

    @GetMapping("/menu/count")
    public Long getMenuCount() {
        return menuMapper.selectCount(null);
    }


    @PostMapping("/menu")
    public Menu createMenu(@RequestBody Menu menu) {
        menuMapper.insert(menu);
        return menu;
    }

    @DeleteMapping("/menu/{id}")
    public int delMenu(@PathVariable("id") int id) {
        return menuMapper.deleteById(id);
    }

    @PutMapping("/menu/{id}")
    public Menu updateMenu(@PathVariable("id") int id, @RequestBody Menu menu) {
        Menu existingUser = menuMapper.selectById(id);
        if (existingUser != null) {
            menu.setId(id);
            menuMapper.updateById(menu);
            return menu;
        } else {
            return null;
        }
    }
}
