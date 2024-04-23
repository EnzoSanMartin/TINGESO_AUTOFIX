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

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoEntity> getVehiculosById(@PathVariable Long id) {
        VehiculoEntity vehiculo = vehiculoService.getVehiculoById(id);
        return ResponseEntity.ok(vehiculo);
    }

    @GetMapping("/{patente}")
    public ResponseEntity<VehiculoEntity> getVehiculoByPatente(@PathVariable String patente) {
        VehiculoEntity vehiculo = vehiculoService.getVehiculoByPatente(patente);
        return ResponseEntity.ok(vehiculo);
    }

    @PostMapping("/")
    public ResponseEntity<VehiculoEntity> saveVehiculo(@RequestBody VehiculoEntity vehiculo) {
        VehiculoEntity vehiculoNew = vehiculoService.saveVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculoNew);
    }

    @PutMapping("/")
    public ResponseEntity<VehiculoEntity> updateVehiculo(@RequestBody VehiculoEntity vehiculo){
        VehiculoEntity vehiculoUpdated = vehiculoService.updateVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteVehiculoById(@PathVariable Long id) throws Exception {
        var isDeleted = vehiculoService.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }

}
