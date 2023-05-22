package com.example.advanceacademy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rooms")
@Builder
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
    @JsonIgnore
    private Hotel hotel;

    @OneToMany(mappedBy = "room",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Reservation> reservations;


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", view=" + view +
                ", floor='" + floor + '\'' +
                ", beds=" + beds +
                ", room_type=" + room_type +
                ", hotel=" + hotel +
                ", reservations=" + reservations +
                '}';
    }
}
