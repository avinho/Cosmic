package com.avinho.backend.controllers;

import com.avinho.backend.entities.Segurado;
import com.avinho.backend.services.SeguradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/segurados")
@RequiredArgsConstructor
public class SeguradoController {

    private final SeguradoService seguradoService;

    @GetMapping
    public ResponseEntity<List<Segurado>> findAll() {
        List<Segurado> segurados = seguradoService.getAll();
        return ResponseEntity.ok(segurados);
    }

    @PostMapping
    public ResponseEntity<Void> saveSegurado(@RequestBody Segurado data) {
        seguradoService.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Segurado> findSeguradoById(@PathVariable(value = "id") Long seguradoId) {
        Segurado segurado = seguradoService.getById(seguradoId);
        return ResponseEntity.ok(segurado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSegurado(@PathVariable(value = "id") Long seguradoId, @RequestBody Segurado data) {
        seguradoService.update(seguradoId, data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSegurado(@PathVariable(value = "id") Long seguradoId) {
        seguradoService.delete(seguradoId);
        return ResponseEntity.noContent().build();
    }
}
