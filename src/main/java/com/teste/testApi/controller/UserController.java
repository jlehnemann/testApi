package com.teste.testApi.controller;


import com.teste.testApi.dto.UserRequest;
import com.teste.testApi.dto.UserResponse;
import com.teste.testApi.entity.User;
import com.teste.testApi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest)  {
        return userService.createUser(userRequest);
    }

    @GetMapping
    public List<UserResponse> listUsers() {
        return userService.listUsers();
    }
}
