package com.example.advanceacademy.convertor;

import com.example.advanceacademy.dto.UserRegisterRequest;
import com.example.advanceacademy.dto.UserResponse;
import com.example.advanceacademy.entity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class UserConverter {

   public User toUser(UserRegisterRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .registerDate(Date.from(Instant.now()))
                .imageUrl(request.getImageUrl())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toResponse(User savedUser){
        return new UserResponse(
                savedUser.getEmail(),
                savedUser.getFirstName(),
                savedUser.getLastName());
    }
}
