package com.avinho.backend.entities.user;

public record RegisterUserDTO(String username, String password, UserRole role) {
}
