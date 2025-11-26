FROM amazoncorretto:17-alpine
WORKDIR /app
COPY target/cardb-0.0.1-SNAPSHOT.jar app.jar
ENV DB_URL="jdbc:mysql://mysqlcar:3306/cardb?useSSL=false&createDatabaseIfNotExist=true&serverTimezone=UTC"
ENV DB_USERNAME="root"
ENV DB_PASSWORD="root"
ENTRYPOINT ["java", "-jar", "/app/app.jar"]