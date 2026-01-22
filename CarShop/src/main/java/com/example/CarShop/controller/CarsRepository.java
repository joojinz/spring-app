package com.example.CarShop.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CarShop.cars.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long>{
    


}
    

