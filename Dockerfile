FROM openjdk:8
ADD target/Gateway-0.0.1-SNAPSHOT.jar Gateway.jar
EXPOSE 9092
ENTRYPOINT ["java", "-jar", "-Xms512m", "-Xmx4096m", "/Gateway.jar"]
