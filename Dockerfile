FROM openjdk:11

ARG JAR_FILE

WORKDIR /app

COPY $JAR_FILE /app/todo.jar

ENTRYPOINT ["java", "-jar", "/app/todo.jar"]
