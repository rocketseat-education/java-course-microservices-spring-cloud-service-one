FROM maven:3.9.6-amazoncorretto-21-debian AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install -DskipTests

FROM amazoncorretto:21

COPY --from=build /app/target/service.tasks-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8881

CMD ["java", "-jar", "app.jar"]