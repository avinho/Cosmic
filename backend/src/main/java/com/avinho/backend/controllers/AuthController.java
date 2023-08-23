package com.avinho.backend.controllers;

import com.avinho.backend.entities.user.AuthUserDTO;
import com.avinho.backend.entities.user.RegisterUserDTO;
import com.avinho.backend.entities.user.User;
import com.avinho.backend.repositories.UserRepository;
import com.avinho.backend.services.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody @Valid AuthUserDTO data) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        User user = (User) auth.getPrincipal();
        String token = tokenService.gerarToken(user);

        return ResponseEntity.ok(token);
    }

    /*
    TODO: Refatorar para o UserService
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register (@RequestBody @Valid RegisterUserDTO data) {
        if(this.userRepository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();

        String encryptedPass = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.username(), encryptedPass, data.role());
        this.userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
