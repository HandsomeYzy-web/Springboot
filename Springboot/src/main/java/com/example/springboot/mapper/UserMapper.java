package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

//省略了包名、导入类
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Delete("DELETE FROM user WHERE username = #{username}")
    int deleteByUsername(@Param("username") String username);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectByUsername(@Param("username") String username);

    @Update("UPDATE user SET username = #{user.username}, password = #{user.password} WHERE username = #{username}")
    int updateByUsername(@Param("username") String username, @Param("user") User user);
}
