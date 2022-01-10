package me.lycheng.st.ping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PingController {

    @GetMapping("/ping")
    public Pong ping(HttpServletResponse response) {
        return new Pong("pong");
    }
}
