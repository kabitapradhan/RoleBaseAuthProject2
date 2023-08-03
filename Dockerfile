FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/RoleBaseAuthProject2-0.0.1-SNAPSHOT.jar RoleBaseAuthProject2.jar
EXPOSE 9099
ENTRYPOINT ["java","-jar","RoleBaseAuthProject2.jar"]