Spring Boot Project Step By Step
===

Project structure will follow the [2.1 Structuring Your Code][1]

# Change Log

0.0.5
---

Features:

* Use the “plural” name to denote the collection resource archetype, `todo` to `todos`
* add Makefile for package build
* Spring boot version updated to 2.6.6
* ControllerAdvice for custom exception handling

References:

* <https://stackoverflow.com/a/50613762>


0.0.4
---

PR: [#3](https://github.com/lycheng/spring-boot-todo-applicaiton/pull/3)

Features:

* package rename to `todoapp`
* introduced MyBatis-Plus for database functions
* introduced mapstruct for Java bean conversion
* docker-compose file for local debug
* version-controlled database schema changes by Flyway

0.0.3
---

PR: [#2](https://github.com/lycheng/spring-boot-todo-applicaiton/pull/2)

Features:

* introduced logback
* CommonInterceptor log api status code and elapsed time
* CommonInterceptor will generate random uuid for empty request trace id

Test with HTTPie

```shell
# new item
http POST http://host.docker.internal:8080/todos/ content=content finished=1

# update item
http put http://host.docker.internal:8080/todos/1 content='new content' finished=0

# get item
http http://host.docker.internal:8080/todos/
http http://host.docker.internal:8080/todos/1

# delete item
http DELETE http://host.docker.internal:8080/todos/1
```

References

* [Chapter 8: Mapped Diagnostic Context][2]

0.0.2
---

PR: [#1](https://github.com/lycheng/spring-boot-todo-applicaiton/pull/1)

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
