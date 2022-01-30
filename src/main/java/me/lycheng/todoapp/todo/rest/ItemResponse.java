package me.lycheng.todoapp.todo.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ItemResponse {
    private Integer id;

    private String content;

    private int finished;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updated;
}
