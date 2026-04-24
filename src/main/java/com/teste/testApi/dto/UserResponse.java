package com.teste.testApi.dto;

import com.teste.testApi.entity.User;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String cpf;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
    }
}
