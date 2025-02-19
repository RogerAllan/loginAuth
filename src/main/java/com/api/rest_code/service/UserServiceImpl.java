package com.api.rest_code.service;


import com.api.rest_code.model.User;
import com.api.rest_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User getEmail(String email) {
        return null;
    }

    @Override
    public User getToken(String token) {
        return null;
    }

    @Override
    public User getPassword(String password) {
        return null;
    }

}
