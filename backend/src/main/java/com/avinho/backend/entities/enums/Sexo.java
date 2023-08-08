package com.avinho.backend.entities.enums;

import lombok.Getter;

@Getter
public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("FEMININO");

    private final String description;

    Sexo(String description) {
        this.description = description;
    }
}
