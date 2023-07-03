package com.example.advanceacademy.dto;

import com.example.advanceacademy.entity.RoomType;
import com.example.advanceacademy.entity.ViewType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    @NumberFormat
    @NotNull(message = "Hotel id is obligatory attribute")
    private Long hotelId;
    private ViewType view;
    @NotNull(message = "Input price for the room")
    private Double price;
    private int quantity;
    @NotNull(message = "Insert quontity of the bads for the room")
    private int bedQuantity;
    private RoomType roomType;


}
