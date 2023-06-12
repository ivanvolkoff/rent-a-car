package com.example.advanceacademy.service;

import com.example.advanceacademy.dto.RoomRequest;
import com.example.advanceacademy.entity.Room;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
     Room addRoom(RoomRequest room);
     Room findById(Long id);
     void deleteRoomById(Long roomId);
}
