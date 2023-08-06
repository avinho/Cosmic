package com.avinho.backend.entities.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {
    PJ("Pessoal Juridica"),
    PF("Pessoa Física");

    private final String type;
    TipoCliente(String type) {
        this.type = type;
    }
}
