FROM openjdk:11-jre-slim

WORKDIR /app

COPY src ./src

COPY target/nodo-almacenamiento.jar ./app.jar

EXPOSE 1099

CMD ["java", "-Djava.rmi.server.hostname=192.168.1.18","-jar", "./app.jar"]