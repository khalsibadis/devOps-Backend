FROM openjdk:11
EXPOSE 8098
ADD target/docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["jasva","-jar","/docker-spring-boot.jar"]