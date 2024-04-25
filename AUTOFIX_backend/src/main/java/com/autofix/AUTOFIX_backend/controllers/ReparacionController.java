package com.autofix.AUTOFIX_backend.controllers;

import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/autofix/v1/reparaciones")
@CrossOrigin("*")
public class ReparacionController {
    @Autowired
    ReparacionService reparacionService;

    @GetMapping("/")
    public ResponseEntity<List<ReparacionEntity>> listReparaciones() {
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        return ResponseEntity.ok(reparaciones);
    }

    @GetMapping("/{precioI}{precioF}")
    public ResponseEntity<List<ReparacionEntity>> listPreciosGasolinaBetween(@PathVariable long precioI, @PathVariable long precioF) {
        List<ReparacionEntity> preciosGasolina = reparacionService.getPrecioGasolinaBetween(precioI, precioF);
        return ResponseEntity.ok(preciosGasolina);
    }

    @GetMapping("/{precioI}{precioF}")
    public ResponseEntity<List<ReparacionEntity>> listPreciosDieselBetween(@PathVariable long precioI, @PathVariable long precioF) {
        List<ReparacionEntity> preciosDiesel = reparacionService.getPrecioDieselBetween(precioI, precioF);
        return ResponseEntity.ok(preciosDiesel);
    }

    @GetMapping("/{precioI}{precioF}")
    public ResponseEntity<List<ReparacionEntity>> listPreciosHibridoBetween(@PathVariable long precioI, @PathVariable long precioF) {
        List<ReparacionEntity> preciosHibrido = reparacionService.getPrecioHibridoBetween(precioI, precioF);
        return ResponseEntity.ok(preciosHibrido);
    }

    @GetMapping("/{precioI}{precioF}")
    public ResponseEntity<List<ReparacionEntity>> listPreciosElectricoBetween(@PathVariable long precioI, @PathVariable long precioF) {
        List<ReparacionEntity> preciosElectrico = reparacionService.getPrecioElectricoBetween(precioI, precioF);
        return ResponseEntity.ok(preciosElectrico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReparacionEntity> getReparracionesById(@PathVariable Long id) {
        ReparacionEntity reparacion = reparacionService.getReparacionById(id);
        return ResponseEntity.ok(reparacion);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<ReparacionEntity> getReparracionesByNombre(@PathVariable String nombre) {
        ReparacionEntity reparacion = reparacionService.getReparacionByNombre(nombre);
        return ResponseEntity.ok(reparacion);
    }

    @PostMapping("/")
    public ResponseEntity<ReparacionEntity> saveReparacion(@RequestBody ReparacionEntity reparacion) {
        ReparacionEntity reparacionNew = reparacionService.saveReparacion(reparacion);
        return ResponseEntity.ok(reparacionNew);
    }

    @PutMapping("/")
    public ResponseEntity<ReparacionEntity> updateReparacion(@RequestBody ReparacionEntity reparacion){
        ReparacionEntity reparacionUpdated = reparacionService.updateReparacion(reparacion);
        return ResponseEntity.ok(reparacionUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReparacionById(@PathVariable Long id) throws Exception {
        var isDeleted = reparacionService.deleteReparacion(id);
        return ResponseEntity.noContent().build();
    }

}
