package com.vrubizha.eduspace.security.repository;

import com.vrubizha.eduspace.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role,Integer> {


    Role findByRole(String role);
}
