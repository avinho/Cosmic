package com.avinho.backend.repositories;

import com.avinho.backend.entities.Companhia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanhiaRepository extends JpaRepository<Companhia, Long> {
}
