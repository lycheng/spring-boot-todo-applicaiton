package me.lycheng.st.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CommonInterceptor implements HandlerInterceptor {

    private static final String javaVersionHeader = "X-Java-Version";

    private static final String appVersionHeader = "X-App-Version";

    @Value("${app.java.version}")
    private String javaVersion;

    @Value("${app.version}")
    private String appVersion;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.addHeader(javaVersionHeader, javaVersion);
        response.addHeader(appVersionHeader, appVersion);
        return true;
    }
}

