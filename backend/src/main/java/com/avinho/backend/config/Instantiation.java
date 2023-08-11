package com.avinho.backend.config;

import com.avinho.backend.entities.Apolice;
import com.avinho.backend.entities.Companhia;
import com.avinho.backend.entities.Segurado;
import com.avinho.backend.entities.enums.*;
import com.avinho.backend.repositories.ApoliceRepository;
import com.avinho.backend.repositories.CompanhiaRepository;
import com.avinho.backend.repositories.SeguradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final SeguradoRepository seguradoRepository;
    private final ApoliceRepository apoliceRepository;
    private final CompanhiaRepository companhiaRepository;
    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        apoliceRepository.deleteAll();
        seguradoRepository.deleteAll();
        companhiaRepository.deleteAll();

        LocalDate date2 = LocalDate.of(2000, 2,11);
        date2.format(fmt);

        Segurado joao = new Segurado("Joao Pinto Rego", date2, "rua 2, bairro america, aracaju-se", "79996424652", "email@email.com", Sexo.MASCULINO, "123456789-12", EstadoCivil.SOLTEIRO, TipoCliente.FISICA);
        Segurado pedro = new Segurado("Pedro Pinto Rego", date2, "rua 2, bairro america, aracaju-se", "79996424652", "email@email.com", Sexo.MASCULINO, "123456789-12", EstadoCivil.CASADO, TipoCliente.FISICA);
        seguradoRepository.saveAll(Arrays.asList(joao, pedro));

        Companhia porto = new Companhia("Porto", "Porto Seguro");
        Companhia mapfre = new Companhia("Mapfre", "Mapfre Seguros");
        companhiaRepository.saveAll(Arrays.asList(porto, mapfre));

        Apolice apolice = new Apolice(joao, porto, Ramo.AUTO, StatusApolice.VIGENTE, BigDecimal.valueOf(123), 15.0, LocalDate.parse("2000-01-01"), LocalDate.parse("2001-01-01"));
        Apolice apolice2 = new Apolice(pedro, mapfre, Ramo.RESIDENCIAL, StatusApolice.VIGENTE, BigDecimal.valueOf(500), 50.0, LocalDate.parse("2004-04-01"), LocalDate.parse("2005-04-01"));

        apoliceRepository.saveAll(Arrays.asList(apolice, apolice2));

        joao.getApolices().add(apolice);
        porto.getApolices().add(apolice);
        pedro.getApolices().add(apolice2);
        mapfre.getApolices().add(apolice2);

        seguradoRepository.saveAll(Arrays.asList(joao, pedro));
        companhiaRepository.saveAll(Arrays.asList(porto, mapfre));
    }
}
