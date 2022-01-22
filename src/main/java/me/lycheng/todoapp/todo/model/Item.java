package me.lycheng.todoapp.todo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("item")
public class Item {

    @TableId
    private int id;

    @TableField
    private String content;

    @TableField
    private int finished;

    @TableField
    private Date created;

    @TableField
    private Date updated;
}
