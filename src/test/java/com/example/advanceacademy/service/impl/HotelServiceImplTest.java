package com.example.advanceacademy.service.impl;

import com.example.advanceacademy.convertor.HotelConverter;
import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;
import com.example.advanceacademy.dto.UpdateHotelRequest;
import com.example.advanceacademy.entity.Address;
import com.example.advanceacademy.entity.Hotel;
import com.example.advanceacademy.exception.NotFoundException;
import com.example.advanceacademy.repository.HotelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HotelServiceImplTest {

    @Mock
    private HotelConverter hotelConverter;
    @Mock
    private HotelRepository hotelRepository;
    @Mock
    private HotelServiceImpl hotelService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        hotelService = new HotelServiceImpl(hotelConverter, hotelRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void saveHotel() {
        //given
        Hotel hotel = new Hotel(1L, "Laguna", "Bulgaria");
        HotelRequest req = new HotelRequest();
        req.setCountry("Bulgaria");
        when(hotelConverter.toHotel(req)).thenReturn(hotel);
        when(hotelRepository.save(hotel)).thenReturn(hotel);
        when(hotelConverter.toResponse(hotel)).thenReturn(new HotelResponse());
        //when
        hotelService.saveHotel(req);

        verify(hotelConverter, times(1)).toHotel(req);
        verify(hotelRepository, times(1)).save(hotel);
        verify(hotelConverter, times(1)).toResponse(hotel);
    }

    @Test
    void saveHotelWithCountryBD() {
        HotelRequest hotelReq = HotelRequest.builder()
                .country("Bangladesh")
                .name("Three star")
                .build();

        hotelService.saveHotel(hotelReq);

        verify(hotelConverter, times(0)).toHotel(hotelReq);
        verify(hotelRepository, times(0)).save(any());

    }

    @Test
    void findByCountryAndCity() {
    }

    @Test
    void findByIdShouldPass() {
        Long id = 1L;

        when(hotelRepository.findById(id)).thenReturn(Optional.ofNullable(Hotel.builder().id(id).build()));

        hotelService.findById(id);

        verify(hotelRepository, times(1)).findById(id);
        verify(hotelConverter, times(1)).toSearchResponse(any());


    }

    @Test
    void updateHotelDetails() {
        Long hotelId = 3L;
        Optional<Hotel> hotel = Optional.of(buildHotel("Kaliakra", "Romania"));
        UpdateHotelRequest updateHotelRequest = new UpdateHotelRequest(
                "Melia", "9000", "+3595323423", "Blvd. Cherno MOre", "asdasd"
        );

        when(hotelRepository.findById(hotelId)).thenReturn(hotel);
        when(hotelRepository.save(hotel.get())).thenReturn(hotel.get());
        when(hotelConverter.toSearchResponse(hotel.get())).thenReturn(new SearchHotelResponse());

        hotelService.updateHotelDetails(hotelId, updateHotelRequest);

        verify(hotelConverter, times(1)).toSearchResponse(hotel.get());
        //
    }

    @Test
    void updateHotelDetailsRepositoryReturnNull() {
        Long hotelId = 3L;
        Optional<Hotel> hotel = Optional.of(buildHotel("Kaliakra", "Romania"));
        UpdateHotelRequest updateHotelRequest = new UpdateHotelRequest(
                "Melia", "9000", "+3595323423", "Blvd. Cherno MOre", "asdasd"
        );

        when(hotelRepository.findById(hotelId)).thenReturn(null);


        assertThatThrownBy(() -> hotelService.updateHotelDetails(hotelId, updateHotelRequest))
                .isInstanceOf(NotFoundException.class)
                .hasMessage(String.format("Hotel with %s not found",hotelId));

        verify(hotelConverter, times(0)).toSearchResponse(null);
        verify(hotelRepository,times(0)).save(any());

    }

    private Hotel buildHotel(String hotelName, String hotelCountry) {
        Address address = Address.builder()
                .country(hotelCountry)
                .city("Varna")
                .isDefault(true)
                .zip("9000")
                .streetAddress("Kniaz Boris")
                .build();
        Hotel hotel = Hotel.builder()
                .id(1L)
                .name(hotelName)
                .address(address)
                .phoneNumber("+35987787767")
                .build();

        return hotel;
    }
}