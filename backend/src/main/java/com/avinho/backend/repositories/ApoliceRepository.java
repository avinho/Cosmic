package com.avinho.backend.repositories;

import com.avinho.backend.entities.Apolice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApoliceRepository extends JpaRepository<Apolice, Long> {
    List<Apolice> findApolicesBySeguradoId(Long id);
}
