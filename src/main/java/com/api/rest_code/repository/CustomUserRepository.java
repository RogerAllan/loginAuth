package com.api.rest_code.repository;

import com.api.rest_code.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public interface CustomUserRepository {
    User customFindByEmail(String email);

    boolean existsByEmail(@Email @NotBlank String email);
}