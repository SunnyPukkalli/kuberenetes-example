FROM openjdk:8

COPY target/kubernetes-example.jar kubernetes-example.jar
EXPOSE 8080 8090
ENTRYPOINT ["java","-jar","kubernetes-example.jar"]