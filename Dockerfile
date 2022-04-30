FROM openjdk:11
VOLUME /tmp
COPY build/libs/desafio.procer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080