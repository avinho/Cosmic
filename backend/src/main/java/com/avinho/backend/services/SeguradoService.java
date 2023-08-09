package com.avinho.backend.services;

import com.avinho.backend.entities.Apolice;
import com.avinho.backend.entities.Segurado;
import com.avinho.backend.repositories.SeguradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeguradoService {
    private final SeguradoRepository repository;

    public List<Segurado> getAllSegurados() {
        List<Segurado> result = repository.findAll();

        return result.stream().map(segurado -> atualizarSegurado(segurado)).toList();
    }

    private Segurado atualizarSegurado(Segurado segurado) {
        List<Apolice> apolices = segurado.getApolices().stream().map(apolice -> atualizarApolice(apolice)).toList();
        segurado.setApolices(apolices);
        return segurado;
    }

    private Apolice atualizarApolice(Apolice apolice) {
        if(apolice.getCompanhia() != null) {
            apolice.setNomeCompanhia(apolice.getCompanhia().getName());
        }
        return apolice;
    }
}
