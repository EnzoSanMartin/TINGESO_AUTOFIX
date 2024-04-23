package com.autofix.AUTOFIX_backend.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "historialReparacion")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HistorialReparacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Date ingresoTaller;/*formato  año (a partir de 1900), mes (0-11), día, hora, minuto, segundo*/
    private String diaIngreso;
    private Long id_reparacion;
    private Long montoTotal;
    private Date terminoReparacion;/*formato  año (a partir de 1900), mes (0-11), día, hora, minuto, segundo*/
    private Date salidaTaller;/*formato  año (a partir de 1900), mes (0-11), día, hora, minuto, segundo*/

}
