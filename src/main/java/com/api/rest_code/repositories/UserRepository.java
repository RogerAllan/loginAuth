package com.api.rest_code.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.rest_code.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
