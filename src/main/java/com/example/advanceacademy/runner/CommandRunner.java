package com.example.advanceacademy.runner;

import com.example.advanceacademy.entity.*;
import com.example.advanceacademy.repository.HotelRepository;
import com.example.advanceacademy.repository.RoomRepository;
import com.example.advanceacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.UUID;

@Component
public class CommandRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        User user = User.builder()
                .firstName("Ivan")
                .lastName("Petkov")
                .email(UUID.randomUUID().toString()+"@gmail.com")
                .password("12097381248")
                .build();

        userRepository.save(user);

        Hotel hotel = Hotel.builder()
                .name("Ramada")
                .address("Sofia")
                .build();

        Hotel savedHotel = hotelRepository.save(hotel);

        Room room = Room.builder()
                .hotel(savedHotel)
                .room_type(RoomType.PREMIUM)
                .beds(3)
                .floor("5")
                .view(ViewType.GARDEN)
                .build();

        Hotel hotel1 = hotelRepository.findById(2L).get();

        System.out.println(hotel1.getRooms());
        Room savedRoom = roomRepository.save(room);
        System.out.println(savedRoom.toString());


    }
}
