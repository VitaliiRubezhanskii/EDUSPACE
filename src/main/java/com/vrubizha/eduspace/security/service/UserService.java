package com.vrubizha.eduspace.security.service;

import com.vrubizha.eduspace.security.domain.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
