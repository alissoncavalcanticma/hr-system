# Projeto Microserviços Java com Spring Boot
User API

### Dependências Spring
- Spring Data JPA  //SQL
- Spring Web //WEB
- Lombok //Developer Tools
- H2 //DB test
- Eureka-client //Auto-discovery client

### Criando Dockerfile:

```` dockerfile
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
````
### Gerando a imagem no DockerHub:

Gerando imagem:

    docker build -t alissoncavalcanticma/user-api:1.0.0 .

Verificando imagem criada

    docker images

### Rodando imagem criada em container Docker:

    docker container run --name user-api -p 8761:8761 alissoncavalcanticma/user-api:1.0.0

### Subindo imagem criada para o DockerHub:

    docker login

    docker push alissoncavalcanticma/user-api:1.0.0