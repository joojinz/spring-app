package com.example.CarShop.controllers;

import com.dto.LoginRequestDTO;
import com.dto.RegisterDTO;
import com.dto.ResponseDTO;
import com.example.CarShop.domain.Users;
import com.example.CarShop.infraSecurity.TokenService;
import com.example.CarShop.repositories.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final TokenService tokenService;

  @PostMapping("/login")
  @SuppressWarnings("rawtypes")
  public ResponseEntity login(@RequestBody LoginRequestDTO body) {
    Users user =
        this.repository
            .findByUserEmail(body.email())
            .orElseThrow(() -> new RuntimeException("User Not Found"));
    if (passwordEncoder.matches(body.password(), user.getUserPassword())) {
      String token = this.tokenService.generateToken(user);
      return ResponseEntity.ok(new ResponseDTO(user.getUserName(), token));
    }
    return ResponseEntity.badRequest().build();
  }

  @PostMapping("/register")
  @SuppressWarnings("rawtypes")
  public ResponseEntity register(@RequestBody RegisterDTO body) {
    Optional<Users> user = this.repository.findByUserEmail(body.email());

    if (user.isEmpty()) {
      Users newUser = new Users(body);
      newUser.setUserPassword(passwordEncoder.encode(body.password()));
      newUser.setUserEmail(body.email());
      newUser.setUserName(body.name());
      newUser.setMoney(body.money());
      this.repository.save(newUser);
      String token = this.tokenService.generateToken(newUser);
      return ResponseEntity.ok(new ResponseDTO(newUser.getUserName(), token));
    }
    return ResponseEntity.badRequest().build();
  }
}
