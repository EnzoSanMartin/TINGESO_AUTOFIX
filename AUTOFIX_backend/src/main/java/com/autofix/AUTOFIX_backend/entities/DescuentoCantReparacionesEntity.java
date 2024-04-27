package com.autofix.AUTOFIX_backend.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "descuentoCantReparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DescuentoCantReparacionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private int cotaInicial;
    private int cotaFinal;
    private int gasolina;
    private int diesel;
    private int hibrido;
    private int electrico;

}
