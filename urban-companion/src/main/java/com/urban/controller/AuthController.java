package com.urban.controller;

import com.urban.dto.RegisterRequest;
import com.urban.model.entity.User;
import com.urban.service.JwtService;
import com.urban.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );

        String token = jwtService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
