package com.example.advanceacademy.dto;

import com.example.advanceacademy.entity.Address;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelResponse {
    private String hotelName;
    private Long id;
    private String phoneNumber;
    private Address address;
}
