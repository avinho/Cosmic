package com.avinho.backend.controllers;

import com.avinho.backend.entities.Segurado;
import com.avinho.backend.services.SeguradoService;
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

    private final SeguradoService seguardoService;

    @GetMapping
    public ResponseEntity<List<Segurado>> findAll() {
        List<Segurado> seguados = seguardoService.getAllSegurados();
        return ResponseEntity.ok(seguados);
    }
}
