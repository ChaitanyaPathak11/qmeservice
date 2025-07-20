package com.cp.qmeservice.service;

import com.cp.qmeservice.model.User;
import com.cp.qmeservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthService
{
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    public User signUp(User user)
    {
        User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null)
        {
            throw new RuntimeException("Email already registered.");
        }
        user.setCreatedAt(Instant.now());
        return userRepository.save(user);
    }

    public User signIn(String email, String password)
    {
        User user = userRepository.findByEmail(email);
        if (user == null)
        {
            throw new RuntimeException("Invalid Email.");
        }

        if (!user.getPassword().equals(password))
        {
            throw new RuntimeException("Invalid Password.");
        }
        return user;
    }
}