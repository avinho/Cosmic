package com.avinho.backend.services;

import com.avinho.backend.entities.Apolice;
import com.avinho.backend.entities.ApoliceRequestDTO;
import com.avinho.backend.repositories.ApoliceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ApoliceService {
    private final ApoliceRepository apoliceRepository;
    private final SeguradoService seguradoService;
    private final CompanhiaService companhiaService;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public Apolice findByNumber(Integer number) {
        return apoliceRepository.findByNumber(number);
    }

    @Transactional
    public void create(ApoliceRequestDTO data) {
        var segurado = seguradoService.getById(data.seguradoId());
        var companhia = companhiaService.findById(data.companhiaId());
        Apolice newApolice = new Apolice(
                data.number(),
                segurado,
                companhia,
                data.ramo(),
                data.statusApolice(),
                data.premio(),
                data.comissao(),
                LocalDate.parse(data.vgInit(), fmt),
                LocalDate.parse(data.vgFinal(), fmt)
        );
        /*newApolice.setSegurado(segurado);
        newApolice.setCompanhia(companhia);
        segurado.getApolices().add(newApolice);
        companhia.getApolices().add(newApolice);*/

        //seguradoService.save(segurado);
        //companhiaService.save(companhia);
        /*if (findByNumber(data.number()) != null) {
            throw new ResourceAreadyExistsException("Já existe uma apólice com numero " + data.number());
        }*/
        apoliceRepository.save(newApolice);
    }
}
