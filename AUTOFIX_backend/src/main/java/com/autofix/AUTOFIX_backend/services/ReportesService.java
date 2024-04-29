package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.HistorialReparacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

@Service
public class ReportesService {
    @Autowired
    VehiculoService vehiculoService;
    @Autowired
    ReparacionService reparacionService;
    @Autowired
    HistorialReparacionService historialReparacionService;

    public List<List<Object>> ordenarListaPorMontoTotal(List<List<Object>> listaReportes) {
        Collections.sort(listaReportes, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> reporte1, List<Object> reporte2) {
                Long montoTotal1 = (Long) reporte1.get(reporte1.size() - 1); // Último elemento de reporte1 es el montoTotal
                Long montoTotal2 = (Long) reporte2.get(reporte2.size() - 1); // Último elemento de reporte2 es el montoTotal
                return montoTotal2.compareTo(montoTotal1); // Orden descendente
            }
        });
        return listaReportes;
    }
    public List<List<Object>> ordenarListaPorAvgMarca(List<List<Object>> listaReportes) {
        Collections.sort(listaReportes, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> reporte1, List<Object> reporte2) {
                Long avgMarca1 = (Long) reporte1.get(1); // El segundo elemento de reporte1 es avgMarca
                Long avgMarca2 = (Long) reporte2.get(1); // El segundo elemento de reporte2 es avgMarca
                return avgMarca1.compareTo(avgMarca2); // Orden ascendente
            }
        });
        return listaReportes;
    }

    public List<List<Object>> R2() {
        List<List<Object>> listaReportes = new ArrayList<>();
        List<Object> reporte = new ArrayList<>();
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        for (ReparacionEntity reparacion : reparaciones){
            String nombre = reparacion.getNombre();
            Long id = reparacion.getId();
            reporte.add(nombre);
            Long montoTotal = 0L;
            List<HistorialReparacionEntity> listaHistorialesReparaciones = historialReparacionService.getHistorialesByIdReparacion(id);

            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipo("sedan", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipo("sedan", listaHistorialesReparaciones);
            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipo("hatchback", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipo("hatchback", listaHistorialesReparaciones);
            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipo("suv", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipo("suv", listaHistorialesReparaciones);
            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipo("pickup", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipo("pickup", listaHistorialesReparaciones);
            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipo("furgoneta", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipo("furgoneta", listaHistorialesReparaciones);

            reporte.add(montoTotal);

            listaReportes.add(reporte);
        }
        return  ordenarListaPorMontoTotal(listaReportes);
    }

    public List<List<Object>> R3() {
        List<List<Object>> listaReportes = new ArrayList<>();
        List<Object> reporte = new ArrayList<>();
        List<String> marcas = List.of("toyota", "kia", "honda", "ford", "chevrolet", "hyundai");
        for (String marca : marcas) {
            reporte.add(marca);
            List<HistorialReparacionEntity> historiales = historialReparacionService.getHistorialesByMarca(marca);
            Long avgMarca = historialReparacionService.avgByMarca(historiales);
            reporte.add(avgMarca);

            listaReportes.add(reporte);
        }
        return ordenarListaPorAvgMarca(listaReportes);
    }

    public List<List<Object>> R4() {
        List<List<Object>> listaReportes = new ArrayList<>();
        List<Object> reporte = new ArrayList<>();
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        for (ReparacionEntity reparacion : reparaciones){
            String nombre = reparacion.getNombre();
            Long id = reparacion.getId();
            reporte.add(nombre);
            Long montoTotal = 0L;
            List<HistorialReparacionEntity> listaHistorialesReparaciones = historialReparacionService.getHistorialesByIdReparacion(id);

            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipoMotor("gasolina", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipoMotor("gasolina",listaHistorialesReparaciones);
            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipoMotor("diesel", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipoMotor("diesel",listaHistorialesReparaciones);
            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipoMotor("hibrido", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipoMotor("hibrido",listaHistorialesReparaciones);
            reporte.add(historialReparacionService.getCountHistorialReparacionesByTipoMotor("electrico", listaHistorialesReparaciones));
            montoTotal += historialReparacionService.getCountMontoByTipoMotor("electrico",listaHistorialesReparaciones);

            reporte.add(montoTotal);

            listaReportes.add(reporte);
        }
        return  ordenarListaPorMontoTotal(listaReportes);
    }

//R4: Listado de los 11 tipos de reparaciones vs el número de vehículos según
//tipo de motor (gasolina, diesel, hibrido, eléctrico) que se repararon y el monto
//total que representa dichas reparaciones. (Ordenar de mayor a menor por
//monto).
}
