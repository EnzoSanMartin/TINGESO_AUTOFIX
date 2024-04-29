package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.HistorialReparacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportesService {
    @Autowired
    VehiculoService vehiculoService;
    @Autowired
    ReparacionService reparacionService;
    @Autowired
    HistorialReparacionService historialReparacionService;

    public List<List<Object>> R1() {
        List<List<Object>> listaReportes = new ArrayList<>();
        List<Object> reporte = new ArrayList<>();
        List<VehiculoEntity> vehiculos = vehiculoService.getVehiculos();
        for (VehiculoEntity vehiculo : vehiculos){
            String patente = vehiculo.getPatente();
            reporte.add(patente);

            List<HistorialReparacionEntity> historiales = historialReparacionService.getHistorialesByPatente(patente);


        }
    }

    /* valores involucrados en el calculo
    * m*/
}
