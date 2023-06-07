package com.example.advanceacademy.convertor;

import com.example.advanceacademy.dto.RoomRequest;
import com.example.advanceacademy.entity.Hotel;
import com.example.advanceacademy.entity.Room;
import com.example.advanceacademy.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter {

    @Autowired
    HotelRepository hotelRepository;

    public Room toRoom(RoomRequest request){

        Hotel hotel = hotelRepository.findById(request.getHotelId()).get();

        return Room.builder()
                .hotel(hotel)
                .price(request.getPrice())
                .beds(request.getBedQuantity())
                .view(request.getView())
                .room_type(request.getRoomType())
                .quantity(request.getQuantity())
                .build();
    }
}
