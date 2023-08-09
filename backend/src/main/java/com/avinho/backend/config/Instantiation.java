package com.avinho.backend.config;

import com.avinho.backend.entities.Apolice;
import com.avinho.backend.entities.Companhia;
import com.avinho.backend.entities.Segurado;
import com.avinho.backend.entities.enums.EstadoCivil;
import com.avinho.backend.entities.enums.Ramo;
import com.avinho.backend.entities.enums.Sexo;
import com.avinho.backend.entities.enums.TipoCliente;
import com.avinho.backend.repositories.ApoliceRepository;
import com.avinho.backend.repositories.CompanhiaRepository;
import com.avinho.backend.repositories.SeguradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final SeguradoRepository seguradoRepository;
    private final ApoliceRepository apoliceRepository;
    private final CompanhiaRepository companhiaRepository;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy");
        dateFmt.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        apoliceRepository.deleteAll();
        seguradoRepository.deleteAll();
        companhiaRepository.deleteAll();

        Segurado joao = new Segurado("Joao Pinto Rego", "rua 2, bairro america, aracaju-se", "79996424652", "email@email.com", Sexo.MASCULINO, "123456789-12", EstadoCivil.SOLTEIRO, TipoCliente.FISICA);
        Segurado pedro = new Segurado("Pedro Pinto Rego", "rua 2, bairro america, aracaju-se", "79996424652", "email@email.com", Sexo.MASCULINO, "123456789-12", EstadoCivil.SOLTEIRO, TipoCliente.FISICA);
        seguradoRepository.save(joao);
        seguradoRepository.save(pedro);

        Companhia porto = new Companhia("Porto", "Porto Seguro");
        companhiaRepository.save(porto);

        Apolice apolice = new Apolice(joao, porto, Ramo.AUTO, LocalDate.parse("2000-01-01"), LocalDate.parse("2001-01-01"));
        Apolice apolice2 = new Apolice(pedro, porto, Ramo.RESIDENCIAL, LocalDate.parse("2004-04-01"), LocalDate.parse("2005-04-01"));

        apoliceRepository.saveAll(Arrays.asList(apolice, apolice2));

        joao.getApolices().add(apolice);
        porto.getApolices().add(apolice);
        //porto.getApolices().add(apolice2);

        //seguradoRepository.save(joao);
        //companhiaRepository.save(porto);
    }
}
