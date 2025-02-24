package br.com.ctfera.user_api.services.impl;

import br.com.ctfera.user_api.domain.User;
import br.com.ctfera.user_api.repository.UserRepository;
import br.com.ctfera.user_api.services.UserService;
import br.com.ctfera.user_api.services.exceptions.ObjectNotFoundException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor(force = true)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}