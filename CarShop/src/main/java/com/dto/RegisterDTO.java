package com.dto;

import java.math.BigDecimal;

public record RegisterDTO(String name, String email, String password, BigDecimal money) {}
