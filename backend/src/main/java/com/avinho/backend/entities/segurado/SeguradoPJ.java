package com.avinho.backend.entities.segurado;

import com.avinho.backend.entities.enums.TipoCliente;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "segurado_pj")
@Data
public class SeguradoPJ extends Segurado implements Serializable {

    private String cnpj;

    public SeguradoPJ() {
        super();
        setTipoCliente(TipoCliente.PJ);
    }

    public SeguradoPJ(String name, String address, String contact, String email, String cnpj) {
        super(name, address, contact, email);
        this.cnpj = cnpj;
        setTipoCliente(TipoCliente.PJ);
    }
}
