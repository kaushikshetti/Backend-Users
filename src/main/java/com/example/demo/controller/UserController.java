package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;
    @Autowired

    public UserController(UserRepository userRepository)
    {
        this.userRepository=userRepository;

    }
    @GetMapping("/user")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User newUser){
        userRepository.save(newUser);
        return newUser;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id) {
        return userRepository.findById(id).orElse(null);
    }
}
