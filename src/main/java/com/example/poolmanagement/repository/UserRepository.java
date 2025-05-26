package com.example.poolmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.poolmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
<<<<<<< HEAD
    List<User> findByRole_RoleName(String roleName);
=======
>>>>>>> feature/nguyen

}
// This interface extends JpaRepository to provide CRUD operations for User entities.