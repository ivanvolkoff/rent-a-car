package com.example.advanceacademy.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JsonManagedReference
    public Set<Room> rooms;

    @OneToMany(mappedBy = "hotel")
    @JsonBackReference
    private Set<Reservation> reservations;

    private String phoneNumber;

    @Override
    public String toString() {
        return "Hotel{" +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                ", reservations=" + reservations +
                '}';
    }
}
