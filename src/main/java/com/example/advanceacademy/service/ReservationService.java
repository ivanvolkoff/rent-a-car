package com.example.advanceacademy.service;

import com.example.advanceacademy.dto.ReservationRequest;
import com.example.advanceacademy.dto.ReservationResponse;
import com.example.advanceacademy.entity.Reservation;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Service
public interface ReservationService {
    Reservation bookReservation(ReservationRequest request);

    ReservationResponse findReservationById(Long id);

    Set<Reservation> findReservationByPeriodWithNative(Instant start, Instant end);
}
