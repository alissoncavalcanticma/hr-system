# Projeto Microserviços Java com Spring Boot
## API Gateway

### Dependências Spring
- Gateway (Spring Cloud Routing) // API Gateway
  - Eureka Discovery Client (Spring Cloud Discovery) //Register service
    - Usar >spring-cloud-starter-gateway, e não >spring-cloud-starter-gateway-mvc
       ````xml
       <artifactId>spring-cloud-starter-gateway</artifactId>
       ````

#### Outras dependências:
      ````xml
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <atifactId>spring-cloud-starter-loadbalancer</artifactId>
      </dependency>
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>	
      </dependency>    
      ````

### Criando Dockerfile:

```` dockerfile
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
````
### Gerando a imagem no DockerHub:

Gerando imagem:

    docker build -t alissoncavalcanticma/api-gateway:1.0.0 .

Verificando imagem criada

    docker images

### Rodando imagem criada em container Docker:

    docker container run --name api-gateway -p 8761:8761 alissoncavalcanticma/api-gateway:1.0.0

### Subindo imagem criada para o DockerHub:

    docker login

    docker push alissoncavalcanticma/api-gateway:1.0.0