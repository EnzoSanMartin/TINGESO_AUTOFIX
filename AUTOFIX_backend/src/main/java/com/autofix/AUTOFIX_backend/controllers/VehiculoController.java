package com.autofix.AUTOFIX_backend.controllers;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autofix/v1/vehiculos")
@CrossOrigin("*")
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @GetMapping("/")
    public ResponseEntity<List<VehiculoEntity>> listVehiculos() {
        List<VehiculoEntity> vehiculos = vehiculoService.getVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

}
