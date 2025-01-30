package com.api.rest_code.repository;

import com.api.rest_code.entity.User;

public interface CustomUserRepository {
    User customFindByEmail(String email);
}