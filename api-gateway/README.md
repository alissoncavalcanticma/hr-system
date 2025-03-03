# Projeto Microserviços Java com Spring Boot
## API Gateway

### Dependências Spring
- Gateway (Spring Cloud Routing) // API Gateway
- Eureka Discovery Client (Spring Cloud Discovery) //Register service
  - Usar >spring-cloud-starter-gateway, e não >spring-cloud-starter-gateway-mvc
     ````xml
                  <artifactId>spring-cloud-starter-gateway</artifactId>
     ````
