package com.avinho.backend.entities;

import com.avinho.backend.entities.enums.Ramo;
import com.avinho.backend.entities.enums.StatusApolice;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ApoliceRequestDTO(
        Integer number,
        String vgInit,
        String vgFinal,
        BigDecimal premio,
        Double comissao,
        Ramo ramo,
        StatusApolice statusApolice,
        Long seguradoId,
        Long companhiaId
) {}
