package com.example.advanceacademy.service.impl;

import com.example.advanceacademy.convertor.HotelConverter;
import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;
import com.example.advanceacademy.dto.UpdateHotelRequest;
import com.example.advanceacademy.entity.Address;
import com.example.advanceacademy.entity.Hotel;
import com.example.advanceacademy.repository.HotelRepository;
import com.example.advanceacademy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    @Override
    public SearchHotelResponse findById(String id) {
        Hotel hotel = hotelRepository.findById(Long.parseLong(id)).get();
        return hotelConverter.toSearchResponse(hotel);
    }

    @Override
    public SearchHotelResponse updateHotelDetails(Long id, UpdateHotelRequest request) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();

        if (request.getName() != null &&!request.getName().isBlank()) {
            hotel.setName(request.getName());
        }
        if ( request.getPhoneNumber() != null && !request.getPhoneNumber().isBlank()) {
            hotel.setPhoneNumber(request.getPhoneNumber());
        }

        Address address = hotel.getAddress();

        if (request.getZip() != null && !request.getZip().isBlank()) {
            address.setZip(request.getZip());
        }
        if (request.getDescription() != null && !request.getDescription().isBlank()) {
            address.setDescription(request.getDescription());
        }
        if (request.getStreetAddress() != null && !request.getStreetAddress().isBlank()) {
            address.setStreetAddress(request.getStreetAddress());
        }

        return hotelConverter.toSearchResponse(hotelRepository.save(hotel));

    }
}
