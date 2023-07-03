package com.example.advanceacademy.service;

import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;
import com.example.advanceacademy.dto.UpdateHotelRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
     HotelResponse saveHotel(HotelRequest request);
     List<SearchHotelResponse> findByCountryAndCity(String country, String city);
     SearchHotelResponse findById(Long id);
     SearchHotelResponse updateHotelDetails(Long id, UpdateHotelRequest request);
}
