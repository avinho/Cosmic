package com.avinho.backend.entities;

import com.avinho.backend.entities.enums.Ramo;
import com.avinho.backend.entities.enums.StatusApolice;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude ="companhia")
public class Apolice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate initialDate;
    @NotNull
    private LocalDate finalDate;
    private BigDecimal premio;
    private Double comissao;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Ramo ramo;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusApolice status;

    @Transient
    private String nomeCompanhia;

    @CreationTimestamp
    @Column(name= "created_at", nullable= false, updatable= false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private Date updatedAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "segurado_id")
    @NotNull
    private Segurado segurado;

    @ManyToOne
    @JoinColumn(name = "companhia_id")
    @JsonIgnore
    @NotNull
    private Companhia companhia;

    public Apolice(Segurado segurado, Companhia companhia, Ramo ramo, StatusApolice status, BigDecimal premio, Double comissao, LocalDate initialDate, LocalDate finalDate) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.premio = premio;
        this.comissao = comissao;
        this.ramo = ramo;
        this.status = status;
        this.segurado = segurado;
        this.companhia = companhia;
    }
}
