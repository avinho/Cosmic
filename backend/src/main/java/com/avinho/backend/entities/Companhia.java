package com.avinho.backend.entities;

import com.avinho.backend.entities.enums.Ramo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "apolices")
public class Companhia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Ramo.class)
    @CollectionTable(name = "companhia_ramos", joinColumns = @JoinColumn(name = "companhia_id"))
    private Set<Ramo> ramos = new HashSet<>();

    @OneToMany(mappedBy = "companhia", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Apolice> apolices = new HashSet<>();

    @CreationTimestamp
    @Column(name= "created_at", nullable= false, updatable= false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private Date updatedAt;

    public Companhia(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
