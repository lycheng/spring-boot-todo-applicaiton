Spring Boot Project Test Step By Step
===

Project structure will follow the [2.1 Structuring Your Code][1]

# Change Log

0.0.3
---

PR: [#2](https://github.com/lycheng/spring-test/pull/2)

Features:

* introduced logback
* CommonInterceptor log api status code and elapsed time
* CommonInterceptor will generate random uuid for empty request trace id

References

* [Chapter 8: Mapped Diagnostic Context][2]

0.0.2
---

PR: [#1](https://github.com/lycheng/spring-test/pull/1)

```java
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter; // Deprecated
```

During the Google search, I found that there still many example about the Interceptor using
the `HandlerInterceptorAdapter` which is deprecated.

Features

* Common Interceptor for common HTTP response headers

0.0.1
---

With only one `/ping` API, no log, no database connection.


[1]: https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code
[2]: https://logback.qos.ch/manual/mdc.html
