package com.vrubizha.eduspace.security.repository;

import com.vrubizha.eduspace.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByRole(String role);
}
