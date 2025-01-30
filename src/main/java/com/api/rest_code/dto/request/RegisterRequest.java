package com.api.rest_code.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import javax.management.relation.Role;

public record RegisterRequest(
        @NotBlank String getFirstname,
        @NotBlank String getLastname,
        @Email @NotBlank String getEmail,
        @NotBlank String getPassword,
        Role role
) {
}
