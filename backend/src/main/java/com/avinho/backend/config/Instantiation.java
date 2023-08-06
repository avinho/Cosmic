package com.avinho.backend.config;

import com.avinho.backend.entities.segurado.SeguradoPF;
import com.avinho.backend.repositories.SeguradoPFRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final SeguradoPFRepository repository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy");
        dateFmt.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        repository.deleteAll();

        SeguradoPF joao = new SeguradoPF(
                "joao",
                "rua 3",
                "1234",
                "email@email.com",
                "123456",
                dateFmt.parse("11/11/1997")
        );

        repository.save(joao);
    }
}
