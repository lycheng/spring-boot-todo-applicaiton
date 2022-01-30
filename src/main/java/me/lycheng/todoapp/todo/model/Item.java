package me.lycheng.todoapp.todo.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("item")
public class Item {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField
    private String content;

    @TableField
    private int finished;

    private Date created;

    private Date updated;
}
