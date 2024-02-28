package com.example.api_user.service;

import com.example.api_user.entity.User;
import com.example.api_user.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository repository;


    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Mono<User> login(String email, String password) {
        return repository.getUserByEmailAndPassword(email, password);
    }

    public Mono<User> register(User user) {
        return repository.save(user);
    }

    public Mono<User> isLogin(String id) {
        return repository.findById(id);
    }

    public Mono<User> getById(String id) {
        return repository.findById(id);
    }
}
