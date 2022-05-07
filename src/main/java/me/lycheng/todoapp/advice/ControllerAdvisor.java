package me.lycheng.todoapp.advice;

import lombok.extern.slf4j.Slf4j;
import me.lycheng.todoapp.constants.MDCKey;
import me.lycheng.todoapp.todo.exception.ItemNotFoundException;
import me.lycheng.todoapp.todo.rest.ExceptionResponse;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> commonExceptionHandler(HttpServletRequest req, Exception ex) {
        var resp = new ExceptionResponse();
        resp.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        resp.setMessage(ex.getMessage());
        resp.setTraceId(MDC.get(MDCKey.TRACE_ID));
        resp.setTimestamp(new Date());
        return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ItemNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> itemNotFoundHandler(HttpServletRequest req, Exception ex) {
        var resp = new ExceptionResponse();
        resp.setCode(HttpStatus.NOT_FOUND.value());
        resp.setMessage(ex.getMessage());
        resp.setTraceId(MDC.get(MDCKey.TRACE_ID));
        resp.setTimestamp(new Date());
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
}
