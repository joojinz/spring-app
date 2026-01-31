package com.dto;

import com.example.CarShop.domain.Cars;

public record CarsResponseDTO(
    Long id, String carName, int carYear, int carValue, String carCondition) {
  public CarsResponseDTO(Cars cars) {
    this(cars.getId(), cars.getCarName(), cars.carYear, cars.getCarValue(), cars.getCarCondition());
  }
}
