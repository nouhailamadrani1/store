package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.UserLoginDto;
import com.ecommerce.ecommerce.dto.UserRegistrationDto;
import com.ecommerce.ecommerce.dto.UserResponseDto;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        try {
            UserResponseDto userResponseDto = userService.registerUser(userRegistrationDto);


            return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDto userLoginDto) {
        try {
            String token = userService.loginUser(userLoginDto);
            return ResponseEntity.ok().header("Authorization", "Bearer " + token).body("Login successful" );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@RequestHeader("Authorization") String token) {
        // Implement logout logic if needed
        return ResponseEntity.ok("Logout successful");
    }
}
