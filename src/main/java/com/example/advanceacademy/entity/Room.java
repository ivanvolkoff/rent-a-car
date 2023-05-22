package com.example.advanceacademy.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ViewType view;

    private String floor;

    private int beds;

    @Enumerated(EnumType.STRING)
    private RoomType room_type;

    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

}
