package com.autofix.AUTOFIX_backend.controllers;

import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
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

    @GetMapping("/{precioGI}{precioGF}")
    public ResponseEntity<List<ReparacionEntity>> listPreciosGasolinaBetween(@PathVariable long precioGI, @PathVariable long precioGF) {
        List<ReparacionEntity> preciosGasolina = reparacionService.getPrecioGasolinaBetween(precioGI, precioGF);
        return ResponseEntity.ok(preciosGasolina);
    }

    @GetMapping("/{precioDI}{precioDF}")
    public ResponseEntity<List<ReparacionEntity>> listPreciosDieselBetween(@PathVariable long precioDI, @PathVariable long precioDF) {
        List<ReparacionEntity> preciosDiesel = reparacionService.getPrecioDieselBetween(precioDI, precioDF);
        return ResponseEntity.ok(preciosDiesel);
    }

    @GetMapping("/{precioHI}{precioHF}")
    public ResponseEntity<List<ReparacionEntity>> listPreciosHibridoBetween(@PathVariable long precioHI, @PathVariable long precioHF) {
        List<ReparacionEntity> preciosHibrido = reparacionService.getPrecioHibridoBetween(precioHI, precioHF);
        return ResponseEntity.ok(preciosHibrido);
    }

    @GetMapping("/{precioEI}{precioEF}")
    public ResponseEntity<List<ReparacionEntity>> listPreciosElectricoBetween(@PathVariable long precioEI, @PathVariable long precioEF) {
        List<ReparacionEntity> preciosElectrico = reparacionService.getPrecioElectricoBetween(precioEI, precioEF);
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
        ReparacionEntity reparacionUpdate = reparacionService.updateReparacion(reparacion);
        return ResponseEntity.ok(reparacionUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReparacionById(@PathVariable Long id) throws Exception {
        var isDeleted = reparacionService.deleteReparacion(id);
        return ResponseEntity.noContent().build();
    }

}
