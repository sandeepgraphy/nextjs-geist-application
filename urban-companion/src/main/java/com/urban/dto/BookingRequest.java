package com.urban.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record BookingRequest(
    @NotNull Long userId,
    @NotBlank String companionId,
    @NotNull @Future LocalDateTime dateTime,
    @Min(1) Integer duration
) {}
