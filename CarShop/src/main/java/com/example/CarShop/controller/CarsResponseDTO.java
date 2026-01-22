package com.example.CarShop.controller;

import com.example.CarShop.cars.Cars;

public record CarsResponseDTO(Long id, String carName, int carYear, int carValue, String carCondition, String email) {
    public CarsResponseDTO(Cars cars){
        this(cars.getId(),cars.getCarName(),cars.carYear, cars.getCarValue(),cars.getCarCondition(),cars.email);

    }
    
}
