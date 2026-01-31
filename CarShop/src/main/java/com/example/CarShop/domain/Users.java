package com.example.CarShop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
  private String user_name;
  private String user_email;
  private Number user_password;
  private Integer user_money;
}
