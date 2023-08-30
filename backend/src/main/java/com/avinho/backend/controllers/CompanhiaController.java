package com.avinho.backend.controllers;

import com.avinho.backend.entities.Companhia;
import com.avinho.backend.entities.CompanhiaRequestDTO;
import com.avinho.backend.services.CompanhiaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/companhias")
@RequiredArgsConstructor
@Tag(name = "Companhia", description = "Endpoint for companhias")
public class CompanhiaController {
    private final CompanhiaService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CompanhiaRequestDTO data) {
        service.addCompanhia(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
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
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
