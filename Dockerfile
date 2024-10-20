FROM maven:3.9.9-eclipse-temurin-17-alpine AS compiler

WORKDIR /app

COPY . .
RUN mv ./src/main/resources/application.properties.example ./src/main/resources/application.properties && \
    mvn clean package -DskipTests

# FROM eclipse-temurin:21.0.4_7-jre-alpine
# FROM tomcat:9.0.96-jre17-temurin-noble
FROM tomcat:10.1.31-jre17-temurin-noble

WORKDIR /usr/local/tomcat/webapps

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=compiler /app/target/*.war ./ROOT.war

EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "/app/application.jar"]
CMD ["catalina.sh", "run"]
