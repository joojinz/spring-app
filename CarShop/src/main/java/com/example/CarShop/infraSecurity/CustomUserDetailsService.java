package com.example.CarShop.infraSecurity;

import com.example.CarShop.domain.Users;
import com.example.CarShop.repositories.UsersRepository;
import java.util.ArrayList;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

  private UsersRepository repository;

  @Override
  public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
    Users user =
        this.repository
            .findByUserEmail(userEmail)
            .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    return new org.springframework.security.core.userdetails.User(
        user.getUserEmail(), user.getUserPassword(), new ArrayList<>());
  }
}
