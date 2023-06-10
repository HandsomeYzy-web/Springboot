package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.pojo.MyOrder;
import com.example.springboot.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select o.* from orders o join receive r on o.orderNum = r.orderNum where delivery=#{delivery} and status=1")
    List<Order> selectOrder(String delivery);
    @Select("select orders.*,o.*,menu.name as menuName,menu.price from orders join orderdetails o on orders.orderNum = o.orderNum join menu on menu.id = o.menuId where username=#{username}")
    List<MyOrder> selectMyOrder(String username);
}