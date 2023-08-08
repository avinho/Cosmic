package com.avinho.backend.entities.enums;

public enum EstadoCivil {
    SOLTEIRO("Automotive"),
    CASADO("residential"),
    DIVORCIADO("Divorciado"),
    UNIAO_ESTAVEL("União Estavel"),
    VIUVO("Viuvo(a)");

    private final String description;

    EstadoCivil(String description) {
        this.description = description;
    }
}

