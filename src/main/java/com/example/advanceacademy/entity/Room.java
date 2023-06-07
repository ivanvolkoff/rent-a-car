package com.example.advanceacademy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Component;

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

    private int beds;

    @Enumerated(EnumType.STRING)
    private RoomType room_type;

    @ManyToOne
    @JsonBackReference
    private Hotel hotel;
    @Column( columnDefinition = "integer default 1")
    private int quantity;

    private double price;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", view=" + view +
                ", beds=" + beds +
                ", room_type=" + room_type +
                '}';
    }
}
