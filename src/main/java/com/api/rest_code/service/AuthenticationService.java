package com.api.rest_code.service;

import com.api.rest_code.dto.request.AuthenticationRequest;
import com.api.rest_code.dto.request.RegisterRequest;
import com.api.rest_code.dto.response.AuthenticationResponse;
import com.api.rest_code.entity.Role;
import com.api.rest_code.entity.User;
import com.api.rest_code.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // User Registration
    public AuthenticationResponse register(RegisterRequest request) {
        // Check if user already exists by email
        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email is already taken.");
        }

        // Create a new user with the provided details
        var user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password())) // Encrypt password
                .role(Role.USER) // Default role
                .build();

        userRepository.save(user); // Save user to the database

        // Generate JWT token for the new user
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build(); // Return the JWT token in the response
    }

    // User Authentication
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Authenticate the user using Spring Security AuthenticationManager
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        // Find the user by email, or throw an exception if not found
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate JWT token for the authenticated user
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build(); // Return the JWT token in the response
    }
}
