package com.example.advanceacademy.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne
    private User user;






}
