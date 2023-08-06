package com.avinho.backend.entities.segurado;

import com.avinho.backend.entities.enums.TipoCliente;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Entity(name = "segurado_pf")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeguradoPF extends Segurado implements Serializable {

    public String cpf;
    public Date birthday;

    public SeguradoPF() {
        super();
        setTipoCliente(TipoCliente.FISICA);
    }

    public SeguradoPF(String name, String address, String contact, String email, String cpf, Date birthday) {
        super(name, address, contact, email);
        this.cpf = cpf;
        this.birthday = birthday;
        setTipoCliente(TipoCliente.FISICA);
    }
}
