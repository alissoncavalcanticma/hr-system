package br.com.ctfera.payroll_api.feignClients;

import br.com.ctfera.payroll_api.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Com serviço simples, sem LoadBalance:  @FeignClient(name = "user-api", url = "http://localhost:8000") //Configurando o client e setando o host que será acessado
@FeignClient(name = "user-api") //Configurando o client e setando o host que será acessado
public interface  UserFeign {

    @GetMapping(value = "/api/users/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<User>> findAll();

}
