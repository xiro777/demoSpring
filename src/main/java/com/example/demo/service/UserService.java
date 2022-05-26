package com.example.demo.service;

import com.example.demo.db_classes.User;
import com.example.demo.web.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
