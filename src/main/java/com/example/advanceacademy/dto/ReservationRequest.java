package com.example.advanceacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationRequest {
    private int stays;
    private Date dateIn;
    private Long userId;
    private Long hotelId;
    private Long roomId;
}
