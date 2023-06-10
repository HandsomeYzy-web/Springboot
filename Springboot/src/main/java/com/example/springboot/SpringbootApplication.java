package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 导入Spring Boot的启动类
import org.springframework.boot.SpringApplication;
// 导入Spring Boot应用程序的自动配置注解
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 标注当前类为Spring Boot应用程序的主类
@SpringBootApplication
@MapperScan("com.example.springboot.mapper")
public class SpringbootApplication {// Spring Boot应用程序的主类
    // 下头男应用程序的入口函数
    public static void main(String[] args) {
        // 启动Spring Boot应用程序
        SpringApplication.run(SpringbootApplication.class, args);
    }
}



