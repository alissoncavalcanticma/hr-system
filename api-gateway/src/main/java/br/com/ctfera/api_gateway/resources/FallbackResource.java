package br.com.ctfera.api_gateway.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackResource {

    @GetMapping("/user")
    public ResponseEntity<String> userServiceFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("O serviço de usuários está temporariamente indisponível. Tente novamente mais tarde.");
    }
}
