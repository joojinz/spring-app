package com.example.CarShop.repositories;

import com.example.CarShop.domain.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
  Optional<Users> findByUserEmail(String user_email);
}
