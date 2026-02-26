package com.example.CarShop.domain;

import com.dto.RegisterDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "user_password")
  private String userPassword;

  @Column(name = "user_money")
  private BigDecimal money;

  public Users(RegisterDTO data) {
    this.userName = data.name();
    this.userEmail = data.email();
    this.userPassword = data.password();
    this.money = data.money() != null ? data.money() : BigDecimal.ZERO;
  }
}
