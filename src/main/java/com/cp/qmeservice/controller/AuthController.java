package com.cp.qmeservice.controller;

import com.cp.qmeservice.model.User;
import com.cp.qmeservice.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController
{
    private final AuthService authService;

    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user)
    {
        return authService.signUp(user);
    }

    @PostMapping("/signin")
    public User signIn(@RequestBody Map<String, String> body)
    {
        String email = body.get("email");
        String password = body.get("password");
        return authService.signIn(email, password);
    }
}
