package com.api.rest_code.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(
        @Email @NotBlank String email,
        @NotBlank String password
) {}
