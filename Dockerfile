FROM openjdk:11
EXPOSE 8089
ADD target/achat-1.1.3.jar achat-1.1.3.jar
ENTRYPOINT ["java", "-jar", "/achat-1.1.2.jar"]