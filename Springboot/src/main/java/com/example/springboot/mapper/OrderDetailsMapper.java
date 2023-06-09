package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.pojo.OrderDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailsMapper extends BaseMapper<OrderDetails> {
}
