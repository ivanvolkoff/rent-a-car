package com.example.advanceacademy.controller;

import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;
import com.example.advanceacademy.service.HotelService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<String> addHotel(@RequestBody HotelRequest request) {
        HotelResponse hotelResponse = hotelService.saveHotel(request);
        String response = String.format("Hotel with %s was created with id %s",
                hotelResponse.getHotelName(), hotelResponse.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/find")
    public ResponseEntity<List<SearchHotelResponse>> findHotelByCountryAndCity(
            @RequestParam String country,
            @RequestParam String city) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(hotelService.findByCountryAndCity(country, city));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchHotelResponse> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.FOUND).body(hotelService.findById(id));
    }
}
