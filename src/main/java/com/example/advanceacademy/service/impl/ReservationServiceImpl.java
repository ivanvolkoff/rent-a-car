package com.example.advanceacademy.service.impl;

import com.example.advanceacademy.convertor.ReservationConverter;
import com.example.advanceacademy.dto.ReservationRequest;
import com.example.advanceacademy.entity.Reservation;
import com.example.advanceacademy.repository.ReservationRepository;
import com.example.advanceacademy.service.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationConverter reservationConverter;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationConverter reservationConverter) {
        this.reservationRepository = reservationRepository;
        this.reservationConverter = reservationConverter;
    }

    @Override
    public Reservation bookReservation(ReservationRequest request) {
        return reservationRepository.save(reservationConverter.toReservation(request));
    }
}
