package com.avinho.backend.services;

import com.avinho.backend.entities.Apolice;
import com.avinho.backend.entities.Companhia;
import com.avinho.backend.entities.CompanhiaRequestDTO;
import com.avinho.backend.entities.Segurado;
import com.avinho.backend.exceptions.ResourceAreadyExistsException;
import com.avinho.backend.exceptions.ResourceNotFoundException;
import com.avinho.backend.repositories.CompanhiaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class CompanhiaService {
    private final CompanhiaRepository companhiaRepository;

    @Transactional
    public void save(Companhia companhia) {
        companhiaRepository.save(companhia);
    }

    @Transactional
    public void addCompanhia(CompanhiaRequestDTO data) {
        Companhia companhia = new Companhia(data.name(), data.description());
        if (companhiaRepository.findByName(companhia.getName()) != null) {
            throw new ResourceAreadyExistsException("Companhia " + data.name() + " already exists");
        }
        companhiaRepository.save(companhia);
    }

    public List<Companhia> getAll() {
        List<Companhia> result = companhiaRepository.findAll();
        result.stream().map(this::atualizarCompanhia).toList();
        return result;
    }

    public Companhia findById(Long id) {
        Companhia companhia = companhiaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Companhia not found with id " + id));
        atualizarCompanhia(companhia);
        return companhia;
    }

    @Transactional
    public void update(Long id, Map<String, Object> data) {
        Companhia companhia = findById(id);
        data.forEach((key, value) -> {
            switch (key) {
                case "name": companhia.setName((String) value);
                case "description": companhia.setName((String) value);
            }
        });
        companhiaRepository.save(companhia);
    }

    @Transactional
    public void delete(Long id) {
        var result = findById(id);
        companhiaRepository.deleteById(result.getId());
    }

    private Companhia atualizarCompanhia(Companhia companhia) {
        companhia.getApolices().stream().map(this::atualizarApolice).toList();
        return companhia;
    }

    private Apolice atualizarApolice(Apolice apolice) {
        if(apolice.getCompanhia() != null) {
            apolice.setNomeCompanhia(apolice.getCompanhia().getName());
        }
        return apolice;
    }
}
