package com.autofix.AUTOFIX_backend.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "recargoKilometraje")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RecargoKilometrajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private double cotaInicial;
    private double cotaFinal;
    private int sedan;
    private int hatchback;
    private int suv;
    private int pickup;
    private int furgoneta;
}
