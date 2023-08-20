package com.avinho.backend.entities.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN( "admin" ),
    USER( "user" );

    private final String description;

    UserRole(String description) {
        this.description = description;
    }
}
