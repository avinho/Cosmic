package com.avinho.backend.services;

import com.avinho.backend.entities.Apolice;
import com.avinho.backend.entities.Segurado;
import com.avinho.backend.exceptions.ResourceNotFoundException;
import com.avinho.backend.repositories.SeguradoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeguradoService {
    private final SeguradoRepository repository;

    public List<Segurado> getAll() {
        List<Segurado> result = repository.findAll();

        return result.stream().map(segurado -> atualizarSegurado(segurado)).toList();
    }

    @Transactional
    public void save(Segurado segurado) {
        repository.save(segurado);
    }

    public Segurado getById(Long seguradoId) {
        Segurado segurado = repository.findById(seguradoId)
                .orElseThrow(()-> new ResourceNotFoundException("Segurado not found with id: " + seguradoId));
        atualizarSegurado(segurado);
        return segurado;
    }

    public Segurado update (Long id, Segurado segurado) {
        try {
            Segurado entity = repository.getReferenceById(id);
            updateData(entity, segurado);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Segurado not found with id: " + id);
        }
    }

    @Transactional
    public void delete(Long seguradoId) {
        Segurado segurado = getById(seguradoId);
        repository.delete(segurado);
    }

    private void updateData(Segurado entity, Segurado data) {
        entity.setName(data.getName());
        entity.setCpfCnpj(data.getCpfCnpj());
        entity.setTipoCliente(data.getTipoCliente());
        entity.setContact(data.getContact());
        entity.setEmail(data.getEmail());
        entity.setDataNascimento(data.getDataNascimento());
        entity.setSexo(data.getSexo());
        entity.setEstadoCivil(data.getEstadoCivil());
        entity.setAddress(data.getAddress());
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
