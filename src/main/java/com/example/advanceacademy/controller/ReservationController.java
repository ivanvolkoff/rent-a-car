package com.example.advanceacademy.controller;

import com.example.advanceacademy.dto.ReservationRequest;
import com.example.advanceacademy.entity.Reservation;
import com.example.advanceacademy.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping()
    public ResponseEntity<Reservation> save(@RequestBody ReservationRequest reservationRequst) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.bookReservation(reservationRequst));
    }
}
