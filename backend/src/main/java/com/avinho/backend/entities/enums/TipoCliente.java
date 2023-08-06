package com.avinho.backend.entities.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {
    FISICA("Pessoa Física"),
    JURIDICA("Pessoa Juridica");

    private final String description;

    TipoCliente(String description) {
        this.description = description;
    }
}
