package com.avinho.backend.config;

import com.avinho.backend.repositories.ApoliceRepository;
import com.avinho.backend.repositories.CompanhiaRepository;
import com.avinho.backend.repositories.SeguradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final SeguradoRepository seguradoRepository;
    private final ApoliceRepository apoliceRepository;
    private final CompanhiaRepository companhiaRepository;
    @Override
    public void run(String... args) throws Exception {
       /* SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy");
        dateFmt.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        Segurado joao = new Segurado("Joao", "rua 2", "123", "email@email.com");
        joao.setTipoCliente(TipoCliente.FISICA);
        seguradoRepository.save(joao);

        Companhia porto = new Companhia("Porto", "Porto Seguro");
        companhiaRepository.save(porto);

        Apolice apolice = new Apolice(joao, porto, Ramo.AUTO);
        Apolice apolice2 = new Apolice(joao, porto, Ramo.RESIDENTIAL);
        apoliceRepository.saveAll(Arrays.asList(apolice, apolice2));

        joao.getApolices().add(apolice);
        //joao.getApolices().add(apolice2);
        seguradoRepository.save(joao);

        //List<Apolice> pedro = apoliceRepository.findApolicesBySeguradoId(1L);

        //System.out.println(pedro);*/
    }
}
