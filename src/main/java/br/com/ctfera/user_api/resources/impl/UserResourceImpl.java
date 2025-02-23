package br.com.ctfera.user_api.resources.impl;

import br.com.ctfera.user_api.domain.User;
import br.com.ctfera.user_api.resources.UserResource;
import br.com.ctfera.user_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Definindo como controlador Rest
@RequestMapping(value="/api/users") //Definindo o basePath dos endpoints
public class UserResourceImpl implements UserResource {

    private final UserService service;

    public UserResourceImpl(UserService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<User> findById(Long id) {
        //return null;
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
