package com.avinho.backend.entities.user;

public record UserResponseDTO(
        Long id,
        String name,
        String username,
        String email,
        UserRole role,
        boolean enabled,
        boolean accountNonExpired,
        boolean credentialsNonExpired,
        boolean accountNonLocked
) {
}
