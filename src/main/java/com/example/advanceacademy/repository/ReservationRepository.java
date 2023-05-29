package com.example.advanceacademy.repository;

import com.example.advanceacademy.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
