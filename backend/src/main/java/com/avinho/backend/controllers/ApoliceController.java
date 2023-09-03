package com.avinho.backend.controllers;

import com.avinho.backend.entities.ApoliceRequestDTO;
import com.avinho.backend.services.ApoliceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apolices")
@RequiredArgsConstructor
public class ApoliceController {
    private final ApoliceService apoliceService;

    @PostMapping
    public ResponseEntity<Void> addNewApolice(@RequestBody @Valid ApoliceRequestDTO data) {
        apoliceService.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
