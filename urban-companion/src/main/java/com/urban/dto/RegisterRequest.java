package com.urban.dto;

import jakarta.validation.constraints.*;

public record RegisterRequest(
    @NotBlank String name,
    @Email String email,
    @Size(min = 6) String password,
    @NotBlank String phone
) {}
