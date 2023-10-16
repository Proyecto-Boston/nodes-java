FROM openjdk:11

CMD ["mvn","package"]

ADD target/nodo-almacenamiento.jar nodo-almacenamiento.jar

ENTRYPOINT ["java", "-jar","nodo-almacenamiento.jar"]

EXPOSE 1099