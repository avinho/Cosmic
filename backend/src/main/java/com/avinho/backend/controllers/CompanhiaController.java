package com.avinho.backend.controllers;

import com.avinho.backend.entities.Companhia;
import com.avinho.backend.entities.CompanhiaRequestDTO;
import com.avinho.backend.services.CompanhiaService;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
TODO: Adicionar endpoint para buscar por nome e adicionar paginação ao findAll
 */
@RestController
@RequestMapping("/companhias")
@RequiredArgsConstructor
@Tag(name = "Companhia", description = "Endpoint for companhias")
public class CompanhiaController {
    private final CompanhiaService service;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid CompanhiaRequestDTO data) {
        try {
            service.addCompanhia(data);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Companhia>> findAll() {
        List<Companhia> result = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Companhia> findById(@PathVariable("id") Long id) {
        var result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Map<String, Object> data) {
        service.update(id, data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
