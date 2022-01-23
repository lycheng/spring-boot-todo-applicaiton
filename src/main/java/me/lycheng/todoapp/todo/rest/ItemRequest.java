package me.lycheng.todoapp.todo.rest;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ItemRequest {

    @NotNull
    private String content;

    @Min(0)
    @Max(1)
    private int finished;
}
