FROM openjdk:11
# make port 8089 available to the world outside this container
EXPOSE 8089
# copy the executable into the containe at /app
ADD target/achat-1.1.2.jar achat-1.1.2.jar
ENTRYPOINT ["java", "-jar", "/achat-1.1.2.jar"]