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

    @GetMapping("/{marca}")
    public ResponseEntity<List<VehiculoEntity>> listMarcas(@PathVariable String marca) {
        List<VehiculoEntity> marcas = vehiculoService.getMarcas(marca);
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{modelo}")
    public ResponseEntity<List<VehiculoEntity>> listModelos(@PathVariable String modelo) {
        List<VehiculoEntity> modelos = vehiculoService.getModelos(modelo);
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<List<VehiculoEntity>> listTipos(@PathVariable String tipo) {
        List<VehiculoEntity> tipos = vehiculoService.getTipos(tipo);
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{tipoMotor}")
    public ResponseEntity<List<VehiculoEntity>> listTiposMotor(@PathVariable String tipoMotor) {
        List<VehiculoEntity> tiposMotor = vehiculoService.getTiposMotor(tipoMotor);
        return ResponseEntity.ok(tiposMotor);
    }

    @GetMapping("/{añoFabricacion}")
    public ResponseEntity<List<VehiculoEntity>> listAñosFabricacion(@PathVariable int añoFabricacion) {
        List<VehiculoEntity> añosFabricacion = vehiculoService.getAñosF(añoFabricacion);
        return ResponseEntity.ok(añosFabricacion);
    }

    @GetMapping("/{kilometros}")
    public ResponseEntity<List<VehiculoEntity>> listKilometros(@PathVariable Long kilometros) {
        List<VehiculoEntity> km = vehiculoService.getKilometros(kilometros);
        return ResponseEntity.ok(km);
    }

    @GetMapping("/{asientos}")
    public ResponseEntity<List<VehiculoEntity>> listAsientos(@PathVariable int asientos) {
        List<VehiculoEntity> NA = vehiculoService.getAsientos(asientos);
        return ResponseEntity.ok(NA);
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

    @GetMapping("/{añoI}{añoF}")
    public ResponseEntity<List<VehiculoEntity>> listAñosFBetween(@PathVariable int añoI, @PathVariable int añoF) {
        List<VehiculoEntity> añosFB = vehiculoService.getAñosFBetween(añoI, añoF);
        return ResponseEntity.ok(añosFB);
    }

    @GetMapping("/{kilometrosI}{kilometrosF}")
    public ResponseEntity<List<VehiculoEntity>> listKilometrosBetween(@PathVariable Long kilometrosI, @PathVariable Long kilometrosF) {
        List<VehiculoEntity> kilometrosBetween = vehiculoService.getKilometrosBetween(kilometrosI, kilometrosF);
        return ResponseEntity.ok(kilometrosBetween);
    }

    @GetMapping("/{asientosI}{asientosF}")
    public ResponseEntity<List<VehiculoEntity>> listAsientosBetween(@PathVariable int asientosI, @PathVariable int asientosF) {
        List<VehiculoEntity> asientosBetween = vehiculoService.getAsientosBetween(asientosI, asientosF);
        return ResponseEntity.ok(asientosBetween);
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
