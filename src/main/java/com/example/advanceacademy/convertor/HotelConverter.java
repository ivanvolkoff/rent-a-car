package com.example.advanceacademy.convertor;

import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;
import com.example.advanceacademy.entity.Address;
import com.example.advanceacademy.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelConverter {

    public Hotel toHotel(HotelRequest request) {
        Address hotelAddress = Address.builder()
                .country(request.getCountry())
                .city(request.getCity())
                .streetAddress(request.getStreetAddress())
                .description(request.getDescription())
                .isDefault(true)
                .zip(request.getZip())
                .build();

        Hotel hotel = Hotel.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .address(hotelAddress)
                .build();

        return hotel;
    }

    public HotelResponse toResponse(Hotel hotel) {
        HotelResponse hotelResponse = new HotelResponse(hotel.getName(),
                hotel.getId(),hotel.getPhoneNumber());

        return hotelResponse;
    }

    public SearchHotelResponse toSearchResponse(Hotel hotel) {
        SearchHotelResponse hotelResponse = new SearchHotelResponse(hotel.getName(),
                hotel.getId(), hotel.getPhoneNumber(),hotel.getAddress());

        return hotelResponse;
    }
}
