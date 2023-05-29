package com.example.advanceacademy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonBackReference
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private Set<Reservation> reservations;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", view=" + view +
                ", floor='" + floor + '\'' +
                ", beds=" + beds +
                ", room_type=" + room_type +
                '}';
    }
}
