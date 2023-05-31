package com.example.advanceacademy.service;

import com.example.advanceacademy.dto.UserRegisterRequest;
import com.example.advanceacademy.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse saveUser(UserRegisterRequest request);

    UserResponse getUser(Long id);

    void deleteUser(Long id);
}
