package com.example.advanceacademy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int stays;

    private Date dateIn;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Hotel hotel;

    private Double price;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;






}
