package com.example.advanceacademy.dto;

import com.example.advanceacademy.entity.Address;
import com.example.advanceacademy.entity.Hotel;
import com.example.advanceacademy.entity.User;
import lombok.*;

import java.time.Instant;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservationResponse {
    private Long id;
    private int stays;
    private String dateIn;
    private String dateOut;
    private HotelResponse hotel;
    private User user;
}
