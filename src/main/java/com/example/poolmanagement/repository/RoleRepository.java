package com.example.poolmanagement.repository;

import com.example.poolmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
}
<<<<<<< HEAD
// This interface extends JpaRepository to provide CRUD operations for Role entities.
=======
>>>>>>> feature/nguyen
