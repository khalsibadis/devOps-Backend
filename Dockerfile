FROM openjdk:11
EXPOSE 8089
ADD target/achat-1.0.jar docker-spring-boot.jar
ENTRYPOINT ["java","-jar","/docker-spring-boot.jar"]
