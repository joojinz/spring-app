package com.example.CarShop.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CarShop.domain.Users;

public interface UsersRepository extends JpaRepository<Users, String>{
    Optional<Users> findByUser_name(String user_name);
    
}
