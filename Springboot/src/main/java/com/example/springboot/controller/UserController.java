package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/user")
    public List<User> getUsers(){  return userMapper.selectList(null); }

    @GetMapping("/user/count")
    public Long getUserCount() {
        return userMapper.selectCount(null);
    }

    @GetMapping("/user/count2")
    public Long getUserCount(@RequestParam(value = "type", required = false) String type) {
        if (type != null && type.equals("delivery")) {
            return userMapper.selectCount(new QueryWrapper<User>().eq("type", "delivery"));
        } else {
            return userMapper.selectCount(null);
        }
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        userMapper.insert(user);
        return user;
    }

    @PutMapping("/user/{username}")
    public User updateUser(@PathVariable("username") String username, @RequestBody User user) {
        User existingUser = userMapper.selectByUsername(username);
        if (existingUser != null) {
            user.setUsername(username);
            int rowsAffected = userMapper.updateByUsername(username, user);
            if (rowsAffected > 0) {
                return user;
            } else {
                return null; // 更新失败
            }
        } else {
            return null; // 用户不存在
        }
    }

    @DeleteMapping("/user/{username}") // 使用其他字段作为标识符，比如用户名
    public int delUser(@PathVariable("username") String username) {
        return userMapper.deleteByUsername(username); // 根据用户名删除记录
    }

}

