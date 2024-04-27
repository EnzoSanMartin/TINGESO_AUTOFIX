package com.autofix.AUTOFIX_backend.controllers;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.HistorialReparacionEntity;
import com.autofix.AUTOFIX_backend.services.VehiculoService;
import com.autofix.AUTOFIX_backend.services.ReparacionService;
import com.autofix.AUTOFIX_backend.services.HistorialReparacionService;
import com.autofix.AUTOFIX_backend.services.ContabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autofix/v1/reportes")
@CrossOrigin("*")
public class ReportesController {
    @Autowired
    VehiculoService vehiculoService;
    @Autowired
    ReparacionService reparacionService;
    @Autowired
    HistorialReparacionService historialReparacionService;
    @Autowired
    ContabilidadService contabilidadService;

    @GetMapping("/{R1]")
    @GetMapping("/{R2]")
    @GetMapping("/{R3]")
    @GetMapping("/{R4]")


}
