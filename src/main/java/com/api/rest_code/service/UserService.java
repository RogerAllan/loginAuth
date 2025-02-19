// Arquivo: src/main/java/com/api/rest_code/service/UserService.java
package com.api.rest_code.service;
import com.api.rest_code.model.User;

public interface UserService {
    User getEmail(String email); //Método para buscar usuário por email
    User getToken(String token);
    User getPassword(String password);
}