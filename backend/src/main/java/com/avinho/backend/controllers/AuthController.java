package com.avinho.backend.controllers;

import com.avinho.backend.entities.user.AuthUserDTO;
import com.avinho.backend.entities.user.RegisterUserDTO;
import com.avinho.backend.entities.user.User;
import com.avinho.backend.repositories.UserRepository;
import com.avinho.backend.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    String login (@RequestBody @Valid AuthUserDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var user = (User) auth.getPrincipal();

        return tokenService.gerarToken(user);
    }

    @PostMapping("/register")
    ResponseEntity register (@RequestBody @Valid RegisterUserDTO data) {
        if(this.userRepository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();

        String encryptedPass = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.username(), encryptedPass, data.role());
        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}
