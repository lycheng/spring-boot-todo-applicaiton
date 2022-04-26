package me.lycheng.todoapp.advice;

import me.lycheng.todoapp.constants.MDCKey;
import me.lycheng.todoapp.todo.rest.ExceptionResponse;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ExceptionResponse commonExceptionHandler(HttpServletRequest req, Exception ex) {
        var resp = new ExceptionResponse();
        resp.setCode(500);
        resp.setMessage(ex.getMessage());
        resp.setTraceId(MDC.get(MDCKey.TRACE_ID));
        resp.setTimestamp(new Date());
        return resp;
    }
}
