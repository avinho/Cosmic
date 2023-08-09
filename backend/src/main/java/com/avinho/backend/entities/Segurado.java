package com.avinho.backend.entities;

import com.avinho.backend.entities.enums.EstadoCivil;
import com.avinho.backend.entities.enums.Sexo;
import com.avinho.backend.entities.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Segurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private Sexo sexo;
    private String cpfCnpj;
    private EstadoCivil estadoCivil;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @OneToMany(mappedBy = "segurado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apolice> apolices = new ArrayList<>();

    @CreationTimestamp
    @Column(name= "created_at", nullable= false, updatable= false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private Date updatedAt;

    public Segurado(String name, String address, String contact, String email, Sexo sexo, String cpfCnpj, EstadoCivil estadoCivil, TipoCliente tipoCliente) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.sexo = sexo;
        this.cpfCnpj = cpfCnpj;
        this.estadoCivil = estadoCivil;
        this.tipoCliente = tipoCliente;
    }
}
