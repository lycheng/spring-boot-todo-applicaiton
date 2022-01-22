package me.lycheng.todoapp.interceptor;

import lombok.extern.slf4j.Slf4j;
import me.lycheng.todoapp.constants.HTTPHeader;
import me.lycheng.todoapp.constants.MDCKey;
import me.lycheng.todoapp.util.RandomGenerator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@Component
public class CommonInterceptor implements HandlerInterceptor {

    @Value("${java.version}")
    private String javaVersion;

    @Value("${app.version}")
    private String appVersion;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.addHeader(HTTPHeader.JAVA_VERSION, javaVersion);
        response.addHeader(HTTPHeader.APP_VERSION, appVersion);

        var traceId = request.getHeader(HTTPHeader.TRACE_ID);
        if (StringUtils.isBlank(traceId)) {
            traceId = RandomGenerator.uuid();
        }
        MDC.put(MDCKey.TRACE_ID, traceId);
        var date = new Date();
        MDC.put(MDCKey.PRE_HANDLE_TIME, String.valueOf(date.getTime()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        var startTime = MDC.get(MDCKey.PRE_HANDLE_TIME);
        long elapsed = 0;
        if (!StringUtils.isEmpty(startTime)) {
            var date = new Date();
            elapsed = date.getTime() - Long.parseLong(startTime);
        }
        log.info(String.format("api=%s status_code=%d elapsed=%dms",
                request.getServletPath(), response.getStatus(), elapsed));
        MDC.clear();
    }
}

