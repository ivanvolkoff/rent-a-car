package com.example.advanceacademy.controller;

import com.example.advanceacademy.dto.RoomRequest;
import com.example.advanceacademy.entity.Room;
import com.example.advanceacademy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping()
    public ResponseEntity<Room> saveRoom(@RequestBody RoomRequest roomRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roomService.addRoom(roomRequest));
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> findById(@PathVariable() Long roomId) {
        return ResponseEntity.ok().body(roomService.findById(roomId));
    }


    @DeleteMapping("/{roomId}")
    public ResponseEntity<String> deleteRoomById(@PathVariable() Long roomId) {
        roomService.deleteRoomById(roomId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Room with " + roomId + " deleted");
    }


}
