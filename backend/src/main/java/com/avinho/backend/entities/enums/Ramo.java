package com.avinho.backend.entities.enums;

import lombok.Getter;

@Getter
public enum Ramo {
    AUTO("Automovel"),
    RESIDENCIAL("Residencial"),
    EMPRESARIAL("Empresarial"),
    VIDA_INDIVIDUAL("Vida Individual"),
    VIDA_GRUPO("Vida em Grupo");

    private final String description;

    Ramo(String description) {
        this.description = description;
    }
}
