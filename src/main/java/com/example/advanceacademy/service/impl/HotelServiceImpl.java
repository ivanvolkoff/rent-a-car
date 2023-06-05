package com.example.advanceacademy.service.impl;

import com.example.advanceacademy.convertor.HotelConverter;
import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;
import com.example.advanceacademy.entity.Hotel;
import com.example.advanceacademy.repository.HotelRepository;
import com.example.advanceacademy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelConverter hotelConverter;
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelConverter hotelConverter, HotelRepository hotelRepository) {
        this.hotelConverter = hotelConverter;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelResponse saveHotel(HotelRequest request) {
        Hotel hotel = hotelConverter.toHotel(request);
        Hotel savedHotel = hotelRepository.save(hotel);

        return hotelConverter.toResponse(savedHotel);
    }

    @Override
    public List<SearchHotelResponse> findByCountryAndCity(String country, String city) {
        List<Hotel> hotels = hotelRepository.findByAddress_Country(country).get();

         return hotels.stream().map(hotel -> hotelConverter.toSearchResponse(hotel))
                .collect(Collectors.toList());
    }
}
