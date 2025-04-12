package com.cp.qmeservice.service;

import com.cp.qmeservice.model.User;
import com.cp.qmeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepository;

    public String signUp(User user)
    {
        if (userRepository.existsByEmail(user.getEmail()))
        {
            return "Email already in use";
        }

        userRepository.save(user);
        return "Sign up successful!";
    }

    public String signIn(String email, String rawPassword)
    {
        return userRepository.findByEmail(email)
                .filter(user -> rawPassword.equals(user.getPassword()))
                .map(user -> "Login successful!")
                .orElse("Invalid email or password");
    }
}