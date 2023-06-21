package com.example.advanceacademy.controller;

import com.example.advanceacademy.convertor.ReservationConverter;
import com.example.advanceacademy.dto.ReservationRequest;
import com.example.advanceacademy.dto.ReservationResponse;
import com.example.advanceacademy.entity.Reservation;
import com.example.advanceacademy.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/reservation")
@Slf4j
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationConverter reservationConverter;
    @PostMapping()
    public ResponseEntity<Reservation> save(@RequestBody ReservationRequest reservationRequst) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.bookReservation(reservationRequst));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReservationResponse> getById(@PathVariable("id") Long reservationId) {
        log.info("Get reservtion id for "+ reservationId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationService.findReservationById(reservationId));
    }

    @GetMapping(path = "/period-native")
    public ResponseEntity<Set<ReservationResponse>> getReservationByPeriod(@RequestParam("start")Instant start,
                                                                           @RequestParam("end")Instant end){
        Set<ReservationResponse> reservationResponses = new HashSet<>();
       reservationService.findReservationByPeriodWithNative(start,end).forEach(
              reservation -> {
                  ReservationResponse reservationResponse = reservationConverter.toReservationResponse(reservation);
                  reservationResponses.add(reservationResponse);
              }
      );

       return ResponseEntity.status(HttpStatus.FOUND).body(reservationResponses);
    }
}
