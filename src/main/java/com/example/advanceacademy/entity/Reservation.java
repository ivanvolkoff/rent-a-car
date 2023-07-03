package com.example.advanceacademy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stays;

    private Instant dateIn;

    private Instant dateOut;

    @JsonIgnore
    @ManyToOne
    @JsonManagedReference
    private Room room;

    @ManyToOne
    @JsonManagedReference
    private Hotel hotel;

    private Double price;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;






}
