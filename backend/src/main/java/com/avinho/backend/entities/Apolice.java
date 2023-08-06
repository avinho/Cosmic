package com.avinho.backend.entities;

import com.avinho.backend.entities.enums.Ramo;
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
    private Ramo ramo;
    private Date vig_inicial;
    private Date vig_final;

    @CreationTimestamp
    @Column(name= "created_at", nullable= false, updatable= false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private Date updatedAt;

}
