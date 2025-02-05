package com.api.rest_code.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;


public record RegisterRequest(
        @NotBlank String firstname, // Fixed field name
        @NotBlank String lastname,  // Fixed field name
        @Email @NotBlank String email, // Fixed field name
        @NotBlank String password   // Fixed field name
) {}