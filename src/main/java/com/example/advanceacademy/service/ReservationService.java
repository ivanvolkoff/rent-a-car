package com.example.advanceacademy.service;

import com.example.advanceacademy.dto.ReservationRequest;
import com.example.advanceacademy.entity.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    Reservation bookReservation(ReservationRequest request);
}
