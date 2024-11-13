package com.demoRest.api.repositories;

import com.demoRest.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByUsername(String name);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}
