package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.pojo.Carts;
import com.example.springboot.pojo.settleCarts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartsMapper extends BaseMapper<Carts> {

    @Select("SELECT c.menu_id AS menu_id, c.quantity AS quantity, m.name AS name, m.price AS price, m.image AS image FROM carts c, menu m WHERE c.menu_id = m.id AND c.userName = #{userName}")
    List<settleCarts> selectSettle(String userName);
}
