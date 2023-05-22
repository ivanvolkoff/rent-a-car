package com.example.advanceacademy.repository;

import com.example.advanceacademy.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
