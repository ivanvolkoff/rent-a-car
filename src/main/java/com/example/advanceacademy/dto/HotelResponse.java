package com.example.advanceacademy.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelResponse {
    private String hotelName;
    private Long id;
    private String phoneNumber;
}
