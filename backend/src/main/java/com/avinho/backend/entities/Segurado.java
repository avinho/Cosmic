package com.avinho.backend.entities;

import com.avinho.backend.entities.enums.EstadoCivil;
import com.avinho.backend.entities.enums.Sexo;
import com.avinho.backend.entities.enums.TipoCliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
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
    @NotNull @NotEmpty
    private String name;
    private String address;
    private String contact;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotNull @NotEmpty @Size(max=14)
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    private LocalDate dataNascimento;

    @NotNull
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

    public Segurado(String name, LocalDate dataNascimento, String address, String contact, String email, Sexo sexo, String cpfCnpj, EstadoCivil estadoCivil, TipoCliente tipoCliente) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.sexo = sexo;
        this.cpfCnpj = cpfCnpj;
        this.estadoCivil = estadoCivil;
        this.tipoCliente = tipoCliente;
    }
}
