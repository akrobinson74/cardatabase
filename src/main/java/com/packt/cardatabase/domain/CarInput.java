package com.packt.cardatabase.domain;

public record CarInput(
        String brand,
        String color,
        String model,
        Integer modelYear,
        Integer price,
        String registrationNumber,
        Long ownerId
) {
}
