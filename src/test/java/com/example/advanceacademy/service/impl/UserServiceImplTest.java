package com.example.advanceacademy.service.impl;

import com.example.advanceacademy.convertor.UserConverter;
import com.example.advanceacademy.entity.User;
import com.example.advanceacademy.exception.NotFoundException;
import com.example.advanceacademy.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserConverter userConverter;

    private UserServiceImpl userService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository, userConverter);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void saveUser() {
    }

    @Test
    void getUser() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        assertThatThrownBy(()->userService.getUser(anyLong()))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("User not found");

        verify(userConverter,times(0)).toResponse(any());

    }

    @Test
    void deleteUser() {
    }
}