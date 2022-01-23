package me.lycheng.todoapp.todo.rest;

import lombok.Data;

import java.util.Date;

@Data
public class DelItemResponse {

    private int id;

    private Date updated;
}
