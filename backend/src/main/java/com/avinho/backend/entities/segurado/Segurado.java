package com.avinho.backend.entities.segurado;

import com.avinho.backend.entities.Apolice;
import com.avinho.backend.entities.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class Segurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contact;
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @ManyToOne
    private Apolice apolices;

    @CreationTimestamp
    @Column(name= "created_at", nullable= false, updatable= false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private Date updatedAt;

    public Segurado() {
    }

    public Segurado(String name, String address, String contact, String email) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }
}
