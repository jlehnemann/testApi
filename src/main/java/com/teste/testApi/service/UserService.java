package com.teste.testApi.service;

import com.teste.testApi.dto.UserRequest;
import com.teste.testApi.dto.UserResponse;
import com.teste.testApi.entity.User;
import com.teste.testApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest userRequest) {
        User user = new User(null, userRequest.getName(), userRequest.getCpf());
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser);
    }

    public List<UserResponse> listUsers() {
        List<User> usersList = userRepository.findAll();
        return usersList.stream().map(UserResponse::new).collect(Collectors.toList());
    }

}
