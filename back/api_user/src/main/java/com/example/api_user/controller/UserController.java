package com.example.api_user.controller;


import com.example.api_user.entity.User;
import com.example.api_user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public Mono<User> getByID(@PathVariable String id) {
        return service.getById(id);
    }


    @PostMapping
    public Mono<User> create(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public Mono<User> login(@RequestBody User user) {
        return service.login(user.getEmail(), user.getPassword());
    }

    @PostMapping("/verify")
    public Mono<User> isLogin(@RequestBody User user) {
        return service.isLogin(user.getId());
    }
}
