package com.avinho.backend.repositories;

import com.avinho.backend.entities.Segurado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguradoRepository extends JpaRepository<Segurado, Long> {
}
