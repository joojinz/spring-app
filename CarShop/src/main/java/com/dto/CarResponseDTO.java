package com.dto;

import com.example.CarShop.domain.Car;
import java.math.BigDecimal;

public record CarResponseDTO(
    Long id, String Model, int Year, BigDecimal Value, String Condition, String Status) {
  public CarResponseDTO(Car cars) {
    this(
        cars.getId(),
        cars.getModel(),
        cars.year,
        cars.getValue(),
        cars.getCondition(),
        cars.getStatus());
  }
}
