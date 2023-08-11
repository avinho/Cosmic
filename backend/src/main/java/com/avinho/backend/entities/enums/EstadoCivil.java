package com.avinho.backend.entities.enums;

import lombok.Getter;

@Getter
public enum EstadoCivil {
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    DIVORCIADO("Divorciado(a)"),
    UNIAO_ESTAVEL("União Estavel"),
    VIUVO("Viuvo(a)");

    private final String description;

    EstadoCivil(String description) {
        this.description = description;
    }
}

