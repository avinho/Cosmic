package com.avinho.backend.entities.enums;

import lombok.Getter;

@Getter
public enum StatusApolice {
    VIGENTE("Vigente"),
    RENOVADA("Renovada"),
    NAO_RENOVADA("Não renovada"),
    VENCIDA("Vencida"),
    CANCELADA("Cancelada");

    private final String description;

    StatusApolice(String description) {
        this.description = description;
    }
}
