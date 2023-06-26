package com.example.advanceacademy.repository;

import com.example.advanceacademy.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM reservations WHERE date_in between ?1 and ?2 AND date_out between ?1 and ?2")
    Optional<Set<Reservation>> getReservationsByIntervalWithNative(String start, String end);

}
