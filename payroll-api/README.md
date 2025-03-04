# Projeto Microserviços Java com Spring Boot
Payroll API

### Dependências Spring
- Spring Web //WEB
- Lombok //Developer Tools
- OpenFeign //Request
- Eureka-client //Register service

### Config Eureka client:
- Incluir dependência no pom.xml:
  ```xml
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
  </dependency>
  ````
- Incluir gestor de dependencias no pom.xml:
  ```` xml
      <dependencyManagement>
          <dependencies>
              <dependency>
                  <groupId>org.springframework.cloud</groupId>
                  <artifactId>spring-cloud-dependencies</artifactId>
                  <version>${spring-cloud.version}</version>
                  <type>pom</type>
                  <scope>import</scope>
              </dependency>
          </dependencies>
      </dependencyManagement>
  ````
  E versão do Spring Cloud nas properties do pom.xml, junto à versão do Java:
  ```` xml
  <properties>
    <java.version>17</java.version>
    <spring-cloud.version>2024.0.0</spring-cloud.version> <<<----- Apenas essa linha
  </properties>
  ````
- Annotation: @EnableDiscoveryClient na Main class
- Incluir properties:
  ```yml 
  eureka:
  client:
    service-url:
      default-zone: ${EUREKA_URL:http://localhost:8761/eureka}
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

    docker build -t alissoncavalcanticma/payroll-api:1.0.0 .

Verificando imagem criada

    docker images

### Rodando imagem criada em container Docker:

    docker container run --name payroll-api -p 8761:8761 alissoncavalcanticma/payroll-api:1.0.0

### Subindo imagem criada para o DockerHub:

    docker login

    docker push alissoncavalcanticma/payroll-api:1.0.0