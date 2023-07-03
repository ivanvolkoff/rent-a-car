package com.example.advanceacademy.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name="addresses")
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

    @OneToOne()
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
