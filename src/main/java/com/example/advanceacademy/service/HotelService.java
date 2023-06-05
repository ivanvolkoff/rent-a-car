package com.example.advanceacademy.service;

import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;

import java.util.List;

public interface HotelService {
     HotelResponse saveHotel(HotelRequest request);
     List<SearchHotelResponse> findByCountryAndCity(String country, String city);
}
