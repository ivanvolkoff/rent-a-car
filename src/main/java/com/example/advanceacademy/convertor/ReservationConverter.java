package com.example.advanceacademy.convertor;

import com.example.advanceacademy.dto.ReservationRequest;
import com.example.advanceacademy.dto.ReservationResponse;
import com.example.advanceacademy.entity.Hotel;
import com.example.advanceacademy.entity.Reservation;
import com.example.advanceacademy.entity.Room;
import com.example.advanceacademy.entity.User;
import com.example.advanceacademy.exception.NotFoundException;
import com.example.advanceacademy.repository.HotelRepository;
import com.example.advanceacademy.repository.UserRepository;
import com.example.advanceacademy.service.RoomService;
import com.example.advanceacademy.util.DateFormatterUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class ReservationConverter {
    @Autowired
    RoomService roomService;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HotelConverter hotelConverter;

    public Reservation toReservation(ReservationRequest request) {
        Room room = roomService.findById(request.getRoomId());
        Reservation reservation = Reservation.builder()
                .user(getUser(request.getUserId()))
                .hotel(getHotel(request.getHotelId()))
                .room(room)
                .dateIn(request.getDateIn())
                .dateOut(getDateOut(request.getStays(), request.getDateIn()))
                .price(request.getStays() * room.getPrice())
                .stays(request.getStays())
                .build();

        return reservation;
    }

    public ReservationResponse toReservationResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .user(reservation.getUser())
                .hotel(hotelConverter.toResponse(reservation.getHotel()))
                .stays(reservation.getStays())
                .dateIn(DateFormatterUtil.getDateFromDateTime(reservation.getDateIn()).toString())
                .dateOut(DateFormatterUtil.getDateFromDateTime(reservation.getDateOut()).toString())
                .id(reservation.getId())
                .build();
    }


    User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Cannot proceed with reservation. User with " + id + " not found"
        ));
    }

    Hotel getHotel(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Cannot proceed with reservation. Hotel with " + id + " not found"
        ));
    }

    Instant getDateOut(int stays, Instant dateIn) {
        return dateIn.plusMillis
                (TimeUnit.MILLISECONDS.convert(stays, TimeUnit.DAYS));
    }


}
