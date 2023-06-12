package com.example.advanceacademy.service.impl;

import com.example.advanceacademy.convertor.RoomConverter;
import com.example.advanceacademy.dto.RoomRequest;
import com.example.advanceacademy.entity.Room;
import com.example.advanceacademy.repository.RoomRepository;
import com.example.advanceacademy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomConverter roomConverter;
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomConverter roomConverter, RoomRepository roomRepository) {
        this.roomConverter = roomConverter;
        this.roomRepository = roomRepository;
    }

    @Override
    public Room addRoom(RoomRequest roomRequest) {
        Room room = roomConverter.toRoom(roomRequest);

        return roomRepository.save(room);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public void deleteRoomById(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}
