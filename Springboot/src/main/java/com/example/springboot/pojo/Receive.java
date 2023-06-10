package com.example.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("receive")
public class Receive {
    @TableId("orderNum")
    private String orderNum;
    private String delivery;
}
