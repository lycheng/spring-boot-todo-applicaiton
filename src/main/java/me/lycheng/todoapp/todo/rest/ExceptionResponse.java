package me.lycheng.todoapp.todo.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResponse {

    private int code;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date timestamp;

    private String message;

    private String traceId;
}
