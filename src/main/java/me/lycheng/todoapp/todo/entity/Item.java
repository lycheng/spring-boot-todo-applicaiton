package me.lycheng.todoapp.todo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @TableField
    private Date created;

    @TableField
    private Date updated;
}
