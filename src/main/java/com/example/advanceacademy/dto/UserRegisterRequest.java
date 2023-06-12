package com.example.advanceacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterRequest {
    @NotBlank
    @Length(min = 3,message = "Name should contain at least 3 characters")
    private String firstName;
    @NotBlank
    @Length(min = 3,message = "Last Name should containt at least 3 characters")
    private String lastName;
    @Email(message = "Enter valid email")
    private String email;
    @Length(min = 8, message = "Password should containt at least 8 characters")
    private String password;
    @URL(message = "Field should be valid URL")
    private String imageUrl;
}
