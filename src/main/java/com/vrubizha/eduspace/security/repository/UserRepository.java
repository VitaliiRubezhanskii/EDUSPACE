package com.vrubizha.eduspace.security.repository;

import com.vrubizha.eduspace.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
