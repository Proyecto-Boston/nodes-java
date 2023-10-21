FROM adoptopenjdk/openjdk11

WORKDIR /app

COPY src ./src

COPY target/nodo-almacenamiento.jar ./app.jar

COPY java.policy /usr/local/openjdk-11/conf/security/java.policy

RUN javac -d bin -cp src/main/java src/main/java/Server.java src/main/java/rmi/RMIService.java src/main/java/rmi/IRMIService.java

EXPOSE 1099

CMD ["java", "-Djava.rmi.server.hostname=192.168.1.18", "-Dcom.sun.management.jmxremote.local.only=false","-Dcom.sun.management.jmxremote.authenticate=false","-Dcom.sun.management.jmxremote.ssl=false","-cp","bin","Server"]
