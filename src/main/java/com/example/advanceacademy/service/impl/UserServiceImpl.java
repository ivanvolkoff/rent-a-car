package com.example.advanceacademy.service.impl;

import com.example.advanceacademy.convertor.UserConverter;
import com.example.advanceacademy.dto.UserRegisterRequest;
import com.example.advanceacademy.dto.UserResponse;
import com.example.advanceacademy.entity.User;
import com.example.advanceacademy.exception.NotFoundException;
import com.example.advanceacademy.repository.UserRepository;
import com.example.advanceacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserResponse saveUser(UserRegisterRequest request) {
        User user = userConverter.toUser(request);

        User savedUser = userRepository.save(user);

        return userConverter.toResponse(savedUser);
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("User not found"));

        return userConverter.toResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
