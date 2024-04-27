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

    private int cotaInicial;
    private int cotaFinal;
    private int sedan;
    private int hatchback;
    private int suv;
    private int pickup;
    private int furgoneta;
}
