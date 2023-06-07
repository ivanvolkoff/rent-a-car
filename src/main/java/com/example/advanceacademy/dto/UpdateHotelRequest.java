package com.example.advanceacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHotelRequest {
    @Min(value = 3,message = "Hotel name should contain at least 3 characters")
    private String name;
    private String zip;
    private String phoneNumber;
    private String streetAddress;
    private String description;
}
