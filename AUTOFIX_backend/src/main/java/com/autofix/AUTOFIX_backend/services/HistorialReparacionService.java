package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.HistorialReparacionEntity;
import com.autofix.AUTOFIX_backend.repositories.HistorialReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class HistorialReparacionService {
    @Autowired
    HistorialReparacionRepository historialReparacionRepository;
    @Autowired
    ContabilidadService contabilidadService;

    public ArrayList<HistorialReparacionEntity> getHistorialReparaciones() {return (ArrayList<HistorialReparacionEntity>) historialReparacionRepository.findAll(); }

    public int getCountReparacionesByPatente(String patente, Date fecha) {return historialReparacionRepository.countReparacionesByPatente(patente, fecha); }

    public boolean calcularMontoTotal() {
        HistorialReparacionEntity historialReparacion = new HistorialReparacionEntity();
        Long montoTotal = contabilidadService.montoTotal(historialReparacion);
        historialReparacion.setMontoTotal(montoTotal);

        historialReparacionRepository.save(historialReparacion);

        return true;
    }

}
