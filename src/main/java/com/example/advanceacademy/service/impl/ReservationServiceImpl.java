package com.example.advanceacademy.service.impl;

import com.example.advanceacademy.convertor.ReservationConverter;
import com.example.advanceacademy.dto.ReservationRequest;
import com.example.advanceacademy.dto.ReservationResponse;
import com.example.advanceacademy.entity.Reservation;
import com.example.advanceacademy.exception.NotFoundException;
import com.example.advanceacademy.repository.ReservationRepository;
import com.example.advanceacademy.service.ReservationService;
import com.example.advanceacademy.util.DateFormatterUtil;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public ReservationResponse findReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()->
                        new NotFoundException(String.format("Reservation for %s not found", id)));
        return reservationConverter.toReservationResponse(reservation);
    }

    @Override
    public Set<Reservation> findReservationByPeriodWithNative(Instant start, Instant end) {
       return reservationRepository.getReservationsByIntervalWithNative(
               DateFormatterUtil.getDateFromDateTime(start).toString(),
               DateFormatterUtil.getDateFromDateTime(end).toString())
               .orElse(Collections.emptySet());
    }

//    public Set<Reservation> findReservationByPeriodWithJpql(Instant start, Instant end) {
//        return reservationRepository.getReservationsByIntervalWithJPQL(start,end).orElse(Collections.emptySet());
//    }
}
