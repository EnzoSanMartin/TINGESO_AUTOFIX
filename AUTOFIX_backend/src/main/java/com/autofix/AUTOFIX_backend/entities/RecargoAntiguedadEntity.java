package com.autofix.AUTOFIX_backend.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "recargoAntiguedad")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RecargoAntiguedadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private double cotaInicial;
    private double cotaFinal;
    private String sedan;
    private String hatchback;
    private String suv;
    private String pickup;
    private String furgoneta;
}
