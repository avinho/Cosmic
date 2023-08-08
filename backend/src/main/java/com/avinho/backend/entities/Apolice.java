package com.avinho.backend.entities;

import com.avinho.backend.entities.enums.Ramo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apolice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "segurado_id")
    private Segurado segurado;

    @ManyToOne
    @JoinColumn(name = "companhia_id")
    @JsonIgnore
    private Companhia companhia;

    @Enumerated(EnumType.STRING)
    private Ramo ramo;

    @CreationTimestamp
    @Column(name= "created_at", nullable= false, updatable= false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private Date updatedAt;

    public Apolice(Segurado segurado, Companhia companhia, Ramo ramo) {
        this.segurado = segurado;
        this.companhia = companhia;
        this.ramo = ramo;
    }
}
