package com.example.CarShop.infraSecurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.CarShop.domain.Users;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(Users users) {
    try {

      Algorithm algorithm = Algorithm.HMAC256(secret);

      String token =
          JWT.create()
              .withIssuer("login-auth-api")
              .withSubject(users.getUserEmail())
              .withExpiresAt(this.generateTimeExpiration())
              .sign(algorithm);
      return token;
    } catch (JWTCreationException e) {

      throw new RuntimeException("Generate token error");
    }
  }

  private Instant generateTimeExpiration() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3"));
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm).withIssuer("login-auth-api").build().verify(token).getSubject();
    } catch (JWTVerificationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
