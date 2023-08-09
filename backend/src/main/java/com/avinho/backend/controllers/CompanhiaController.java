package com.avinho.backend.controllers;

import com.avinho.backend.entities.Companhia;
import com.avinho.backend.repositories.CompanhiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companhia")
@RequiredArgsConstructor
public class CompanhiaController {

    private final CompanhiaRepository repository;

    @GetMapping
    public ResponseEntity<List<Companhia>> findAll() {
        List<Companhia> result = repository.findAll();
        return ResponseEntity.ok(result);
    }
}
