package com.example.advanceacademy.runner;

import com.example.advanceacademy.entity.*;
import com.example.advanceacademy.repository.HotelRepository;
import com.example.advanceacademy.repository.ReservationRepository;
import com.example.advanceacademy.repository.RoomRepository;
import com.example.advanceacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Component
public class CommandRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        User user = User.builder()
//                .firstName("Ivan")
//                .lastName("Petkov")
//                .email(UUID.randomUUID().toString()+"@gmail.com")
//                .password("12097381248")
//                .build();
//
//        userRepository.save(user);
//
//        Hotel hotel = Hotel.builder()
//                .name("Ramada")
//                .address("Sofia")
//                .build();
//
//        Hotel savedHotel = hotelRepository.save(hotel);
//
//        Room room = Room.builder()
//                .hotel(savedHotel)
//                .room_type(RoomType.PREMIUM)
//                .beds(3)
//                .floor("5")
//                .view(ViewType.GARDEN)
//                .build();
//
//        Hotel hotel1 = hotelRepository.findById(1L).get();
//        System.out.println("HERE");
//        System.out.println(hotel1.getRooms());
//        Room savedRoom = roomRepository.save(room);
//        System.out.println(savedRoom.toString());
//
//
//        Reservation reservation = Reservation.builder()
//                .dateIn(Date.from(Instant.now()))
//                .hotel(hotel1)
//                .price(450.0)
//                .stays(5)
//                .user(user)
//                .room(roomRepository.findById(1L).get())
//                .build();
//
//         Reservation savedReservation = reservationRepository.save(reservation);
//         Reservation myReservation = reservationRepository.findById(1L)
//                 .orElse(new Reservation());
//        System.out.println(myReservation);



    }
}
