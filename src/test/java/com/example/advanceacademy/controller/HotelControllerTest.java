package com.example.advanceacademy.controller;

import com.example.advanceacademy.dto.HotelRequest;
import com.example.advanceacademy.dto.HotelResponse;
import com.example.advanceacademy.dto.SearchHotelResponse;
import com.example.advanceacademy.entity.Address;
import com.example.advanceacademy.service.impl.HotelServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class HotelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelServiceImpl hotelService;

    @Autowired
    private ObjectMapper objectMapper;

    private AutoCloseable autoCloseable;

    @BeforeEach
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);

    }

    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void addHotel() throws Exception {
        HotelRequest hotelRequest = new HotelRequest("ABC", "Bulgaria", "Varna", "9000", "1231234", "asasf", "asdasfgad");
        HotelResponse hotelResponse = new HotelResponse("ABC", 12L, "1231234", new Address());

        when(hotelService.saveHotel(any(HotelRequest.class))).thenReturn(hotelResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hotel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(hotelResponse)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Hotel with name ABC was created with id 12"));
    }

    @Test
    public void testFindByCountry() throws Exception {
        String country = "Romania";
        String city = "Constanta";

        List<SearchHotelResponse> result = new ArrayList<>();
        result.add(new SearchHotelResponse("Luna", 123L, "123123123", new Address()));

        when(hotelService.findByCountryAndCity(eq(country), eq(city))).thenReturn(result);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hotel/find")
                        .param("country", country)
                        .param("city", city))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelName").value("Luna"));
    }

}