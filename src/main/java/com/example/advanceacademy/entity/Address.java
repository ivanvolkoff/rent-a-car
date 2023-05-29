package com.example.advanceacademy.entity;

import javax.persistence.*;

@Entity
@Table(name="user_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String zip;
    private String streetAddress;
    private String description;
    private Boolean isDefault;
}
