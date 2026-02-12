package com.example.CarShop.controllers;

import com.dto.CarsRequestDTO;
import com.dto.CarsResponseDTO;
import com.example.CarShop.repositories.CarsRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/cars")
public class CarsController {

  @Autowired private CarsRepository repository;

  @GetMapping
  public List<CarsResponseDTO> getAllCars() {

    List<CarsResponseDTO> carsList =
        repository.findAll().stream().map(CarsResponseDTO::new).collect(Collectors.toList());

    System.out.println(carsList.size());
    return carsList;
  }
  ;

  @PostMapping()
  public void saveNewCars(@RequestBody CarsRequestDTO Data) {}
}
