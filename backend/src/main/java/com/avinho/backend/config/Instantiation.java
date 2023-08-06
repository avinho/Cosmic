package com.avinho.backend.config;

import com.avinho.backend.entities.segurado.SeguradoPF;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy");
        dateFmt.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        SeguradoPF joao = new SeguradoPF(
                "joao",
                "rua 3",
                "1234",
                "email@email.com",
                "123456",
                dateFmt.parse("11/11/1997")
        );

        System.out.println(joao);
    }
}
