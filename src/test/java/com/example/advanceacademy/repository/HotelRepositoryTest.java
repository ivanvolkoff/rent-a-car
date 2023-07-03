package com.example.advanceacademy.repository;

import com.example.advanceacademy.entity.Address;
import com.example.advanceacademy.entity.Hotel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        hotelRepository.deleteAll();
    }

    @Test
    void checkMessage(){
         String msg = "Hello";
         String response = "Hello";

         assertEquals(msg,response);
    }

    @Test
    void findByAddress_Country() {
        //given
       Hotel hotel = buildHotel("Metropolitan","Bulgaria");
       //when
        hotelRepository.save(hotel);

        Optional<List<Hotel>> hotels = hotelRepository.findByAddress_Country("Bulgaria");
        // then
        assertThat(hotels).isNotNull();
        assertThat(hotels.get().size()).isEqualTo(1);

    }

    @Test
    void findByAddress_CountryShouldFail() {
        //given
        Hotel hotel = buildHotel("Hilton","USA");
        //when
        hotelRepository.save(hotel);

        Optional<List<Hotel>> hotels = hotelRepository.findByAddress_Country("Bulgaria");
        // then
        assertThat(hotels.get()).isNotNull();
        assertThat(hotels.get().size()).isEqualTo(0);
    }


    private Hotel buildHotel(String hotelName,String hotelCountry){
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