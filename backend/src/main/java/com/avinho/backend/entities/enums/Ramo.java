package com.avinho.backend.entities.enums;

import lombok.Getter;

@Getter
public enum Ramo {
    AUTO("Automotive"),
    RESIDENTIAL("residential"),
    BUSINESS("Business"),
    IND_LIFE("Individual Life"),
    GP_LIFE("Group Life"),;

    private final String description;

    Ramo(String description) {
        this.description = description;
    }
}
