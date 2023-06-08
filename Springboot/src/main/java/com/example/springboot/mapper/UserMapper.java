package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

//省略了包名、导入类
@Mapper
public interface UserMapper extends BaseMapper<User> { }
