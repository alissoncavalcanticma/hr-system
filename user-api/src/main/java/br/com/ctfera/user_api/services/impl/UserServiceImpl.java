package br.com.ctfera.user_api.services.impl;

import br.com.ctfera.user_api.domain.User;
import br.com.ctfera.user_api.repository.UserRepository;
import br.com.ctfera.user_api.services.UserService;
import br.com.ctfera.user_api.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;


import java.util.List;

@ControllerAdvice
@Slf4j
//@NoArgsConstructor(force = true)
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    //private final Environment env;

    private HttpServletRequest request;

    @Override
    public User findById(Long id) {
        //log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");

        log.info("USER_SERVICE ::: Get request on " + request.getLocalPort()  + " port");

        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}