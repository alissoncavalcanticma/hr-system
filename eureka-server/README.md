# Projeto Microserviços Java com Spring Boot
Eureka-server Auto-discovery

### Dependências Spring
- (Spring Cloud Discovery) Eureka server //Server de auto-discovery


### Criando Dockerfile:

```` dockerfile
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
````
### Gerando a imagem no DockerHub:

Gerando imagem:
    
    docker build -t alissoncavalcanticma/eureka-server:1.0.0 .

Verificando imagem criada

    docker images

### Rodando imagem criada em container Docker:

    docker container run --name eureka-server -p 8761:8761 alissoncavalcanticma/eureka-server:1.0.0

### Subindo imagem criada para o DockerHub:

    docker login

    docker push alissoncavalcanticma/eureka-server:1.0.0