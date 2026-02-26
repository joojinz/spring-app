package com.example.CarShop.service;

import com.example.CarShop.domain.Car;
import com.example.CarShop.domain.Users;
import com.example.CarShop.repositories.CarRepository;
import com.example.CarShop.repositories.UserRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PurchaseService {

  private final UserRepository usersRepository;
  private final CarRepository carRepository;

  @Transactional
  public void checkout(String userID, Integer carID) {

    Users users =
        usersRepository
            .findById(userID)
            .orElseThrow(() -> new IllegalArgumentException("user not found"));

    Car car =
        carRepository
            .findById(carID)
            .orElseThrow(() -> new IllegalArgumentException("car not found"));

    if ("SOLD".equals(car.getStatus())) {
      throw new IllegalArgumentException("Car already sold");
    }

    if (users.getMoney().compareTo(car.getValue()) < 0) {
      throw new IllegalArgumentException("Not enough cash, stranger");
    }
    BigDecimal newUserMoney = users.getMoney().subtract(car.getValue());
    users.setMoney(newUserMoney);

    car.setStatus("SOLD");

    carRepository.save(car);
    usersRepository.save(users);
  }
}
