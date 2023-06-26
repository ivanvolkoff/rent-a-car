package com.example.advanceacademy.service;

import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;
import com.example.advanceacademy.dto.UpdateHotelRequest;

import java.util.List;

public interface HotelService {
     HotelResponse saveHotel(HotelRequest request);
     List<SearchHotelResponse> findByCountryAndCity(String country, String city);
     SearchHotelResponse findById(Long id);
     SearchHotelResponse updateHotelDetails(Long id, UpdateHotelRequest request);
}
