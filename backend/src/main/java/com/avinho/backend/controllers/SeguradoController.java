package com.avinho.backend.controllers;

import com.avinho.backend.entities.Segurado;
import com.avinho.backend.repositories.SeguradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/segurados")
@RequiredArgsConstructor
public class SeguradoController {

    private final SeguradoRepository repository;

    @GetMapping
    public ResponseEntity<List<Segurado>> findAll() {
        List<Segurado> segurados = repository.findAll();
        return ResponseEntity.ok(segurados);
    }
}
