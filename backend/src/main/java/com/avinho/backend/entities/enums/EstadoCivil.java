package com.avinho.backend.entities.enums;

import lombok.Getter;

@Getter
public enum EstadoCivil {
    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    DIVORCIADO("Divorciado(a)"),
    UNIAO_ESTAVEL("União Estavel"),
    VIUVO("Viuvo(a)");

    private final String description;

    EstadoCivil(String description) {
        this.description = description;
    }
}

