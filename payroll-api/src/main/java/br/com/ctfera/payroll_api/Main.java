package br.com.ctfera.payroll_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //Habilitando client Feign
@EnableDiscoveryClient //Habilitando o auto-discovery do service com o Eureka
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}