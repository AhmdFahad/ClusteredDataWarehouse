FROM amazoncorretto:21-alpine3.19
EXPOSE 8080
COPY target/clustered-data-warehouse.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
