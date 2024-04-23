package com.autofix.AUTOFIX_backend.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "bono")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BonoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String marca;
    private int cantBonos;
    private Long monto;
}
