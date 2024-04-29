package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.HistorialReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.RecargoKilometrajeEntity;
import com.autofix.AUTOFIX_backend.entities.RecargoAntiguedadEntity;
import com.autofix.AUTOFIX_backend.entities.DescuentoCantReparacionesEntity;
import com.autofix.AUTOFIX_backend.entities.BonoEntity;
import com.autofix.AUTOFIX_backend.repositories.HistorialReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class HistorialReparacionService {
    @Autowired
    HistorialReparacionRepository historialReparacionRepository;
    @Autowired
    VehiculoService vehiculoService;
    @Autowired
    ReparacionService reparacionService;
    @Autowired
    RecargoKilometrajeService recargoKilometrajeService;
    @Autowired
    RecargoAntiguedadService recargoAntiguedadService;
    @Autowired
    DescuentoCantReparacionesService descuentoCantReparacionesService;
    @Autowired
    BonoService bonoService;

    public ArrayList<HistorialReparacionEntity> getHistorialReparaciones() {return (ArrayList<HistorialReparacionEntity>) historialReparacionRepository.findAll(); }
    public ArrayList<HistorialReparacionEntity> getHistorialesByPatente(String patente) {return (ArrayList<HistorialReparacionEntity>) historialReparacionRepository.findByPatente(patente); }
    public ArrayList<HistorialReparacionEntity> getHistorialesByIdReparacion(Long id) {
        List<HistorialReparacionEntity> historiales = getHistorialReparaciones();
        ArrayList<HistorialReparacionEntity> listaHistoriales = new ArrayList<>();
        for (HistorialReparacionEntity historialReparacion : historiales){
            if (historialReparacion.getIdReparaciones().contains(id)) {
                listaHistoriales.add(historialReparacion);
            }
        }
        return listaHistoriales;
    }
    public ArrayList<HistorialReparacionEntity> getHistorialesByMarca(String marca) {
        List<HistorialReparacionEntity> historiales = getHistorialReparaciones();
        ArrayList<HistorialReparacionEntity> listaHistoriales = new ArrayList<>();
        for (HistorialReparacionEntity historialReparacion : historiales) {
            List<VehiculoEntity> vehiculos = vehiculoService.getMarcas(marca);
            String patenteH = historialReparacion.getPatente();
            for (VehiculoEntity vehiculo : vehiculos) {
                if (patenteH.equals(vehiculo.getPatente())) {
                    listaHistoriales.add(historialReparacion);
                }
            }
        }
        return listaHistoriales;
    }
    public Long avgByMarca(List<HistorialReparacionEntity> lista) {
        int cant = 0;
        Long cantFinal = 0L;
        for (HistorialReparacionEntity historial : lista) {
            Long fechaIngreso = historial.getIngresoTaller().getTime();
            Long fechaTermino = historial.getTerminoReparacion().getTime();
            Long diferencia = fechaTermino - fechaIngreso;
            cant += 1;
            cantFinal += diferencia;
        }
        cantFinal = (cantFinal / cant);
        Long tiempoPromedio = TimeUnit.DAYS.convert(cantFinal, TimeUnit.MILLISECONDS);

        return tiempoPromedio;
    }

    public int getCountHistorialReparacionesByTipo(String tipo, List<HistorialReparacionEntity> lista) {
        int cant = 0;
        for (HistorialReparacionEntity historial : lista) {
            String newTipo = vehiculoService.getVehiculoByPatente(historial.getPatente()).getTipo();
            if (tipo.equals(newTipo.toLowerCase())){
                cant += 1;
            }
        }
        return cant;
    }
    public Long getCountMontoByTipo(String tipo, List<HistorialReparacionEntity> lista) {
        Long cant = 0L;
        for (HistorialReparacionEntity historial : lista) {
            String newTipo = vehiculoService.getVehiculoByPatente(historial.getPatente()).getTipo();
            if (tipo.equals(newTipo.toLowerCase())){
                cant += historial.getMontoTotal();
            }
        }
        return cant;
    }

    public int getCountHistorialReparacionesByTipoMotor(String tipoMotor, List<HistorialReparacionEntity> lista) {
        int cant = 0;
        for (HistorialReparacionEntity historial : lista) {
            String newTipoMotor = vehiculoService.getVehiculoByPatente(historial.getPatente()).getTipoMotor();
            if (tipoMotor.equals(newTipoMotor.toLowerCase())){
                cant += 1;
            }
        }
        return cant;
    }
    public Long getCountMontoByTipoMotor(String tipoMotor, List<HistorialReparacionEntity> lista) {
        Long cant = 0L;
        for (HistorialReparacionEntity historial : lista) {
            String newTipoMotor = vehiculoService.getVehiculoByPatente(historial.getPatente()).getTipoMotor();
            if (tipoMotor.equals(newTipoMotor.toLowerCase())) {
                cant += historial.getMontoTotal();
            }
        }
        return cant;
    }

    public int getCountReparacionesByPatente(String patente, Date fecha) {return historialReparacionRepository.countReparacionesByPatente(patente, fecha); }


    public Long sumReparaciones(HistorialReparacionEntity historialReparacion) {
        Long sumaFinal = 0L;
        List<Long> listaReparaciones = historialReparacion.getIdReparaciones();
        VehiculoEntity vehiculo =  vehiculoService.getVehiculoByPatente(historialReparacion.getPatente());
        for (int i = 0; i < listaReparaciones.size(); i++) {
            ReparacionEntity reparacion = reparacionService.getReparacionById(listaReparaciones.get(i));
            switch (vehiculo.getTipoMotor().toLowerCase()) {
                case "gasolina" :
                    sumaFinal += reparacion.getPrecioGasolina();
                case "diesel" :
                    sumaFinal += reparacion.getPrecioDiesel();
                case "hibrido" :
                    sumaFinal += reparacion.getPrecioHibrido();
                case "electrico" :
                    sumaFinal += reparacion.getPrecioElectrico();
            }
        }
        int descuento = 0;
        Long recargo = 0L;

        //DESCUENTOS
        String diaIngreso = historialReparacion.getDiaIngreso().toLowerCase();
        int horaIngreso = historialReparacion.getIngresoTaller().getHours();

        if ((diaIngreso.equals("lunes") || diaIngreso.equals("jueves")) && (horaIngreso >= 9 && horaIngreso <= 12)) {
            descuento += 10;
        }

        Date fechaActual = historialReparacion.getIngresoTaller();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        calendar.add(Calendar.MONTH, -12);
        Date nuevaFecha = calendar.getTime();

        int cantReparaciones = historialReparacionRepository.countReparacionesByPatente(historialReparacion.getPatente(),nuevaFecha);
        DescuentoCantReparacionesEntity descuentoCantReparaciones = descuentoCantReparacionesService.getCant(cantReparaciones);

        switch (vehiculo.getTipoMotor().toLowerCase()) {
            case "gasolina" :
                descuento += descuentoCantReparaciones.getGasolina();
            case "diesel" :
                descuento += descuentoCantReparaciones.getDiesel();
            case "hibrido" :
                descuento += descuentoCantReparaciones.getHibrido();
            case "electrico" :
                descuento += descuentoCantReparaciones.getElectrico();
        }

        //RECARGOS
        Long fechaTermino = historialReparacion.getTerminoReparacion().getTime();
        Long fechaSalida = historialReparacion.getSalidaTaller().getTime();
        Long diferencia = fechaSalida - fechaTermino;
        Long diasDiferencia = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS);
        recargo += (diasDiferencia * 5);

        //BONOS
        BonoEntity bono = bonoService.getMarca(vehiculo.getMarca());
        if (bono.getCantBonos() != 0) {
            sumaFinal = sumaFinal - bono.getMonto();
            bono.setCantBonos(bono.getCantBonos() - 1);
            bonoService.updateBono(bono);
        }

        sumaFinal = sumaFinal + ((sumaFinal * (recargo - descuento))/ 100);

        return sumaFinal;
    }


    public Long montoTotal(HistorialReparacionEntity historialReparacion) {
        Long totalReparaciones = sumReparaciones(historialReparacion);
        VehiculoEntity vehiculo =  vehiculoService.getVehiculoByPatente(historialReparacion.getPatente());
        Long sumaFinal = totalReparaciones + ((totalReparaciones * 19)/100);
        int recargo = 0;
        int descuento = 0;

        //DESCUENTOS

        //RECARGOS
        Long kilometraje = vehiculo.getKilometros();
        String tipo = vehiculo.getTipo();
        RecargoKilometrajeEntity recargoKilometraje = recargoKilometrajeService.getKM(kilometraje);
        switch (tipo.toLowerCase()) {
            case "sedan" :
                recargo += recargoKilometraje.getSedan();
            case "hatchback" :
                recargo += recargoKilometraje.getHatchback();
            case "suv" :
                recargo += recargoKilometraje.getSuv();
            case "pickup" :
                recargo += recargoKilometraje.getPickup();
            case "furgoneta" :
                recargo += recargoKilometraje.getFurgoneta();
        }
        int año = vehiculo.getAñoFabricacion();
        RecargoAntiguedadEntity recargoAntiguedad = recargoAntiguedadService.getAño(año);
        switch (tipo.toLowerCase()) {
            case "sedan" :
                recargo += recargoAntiguedad.getSedan();
            case "hatchback" :
                recargo += recargoAntiguedad.getHatchback();
            case "suv" :
                recargo += recargoAntiguedad.getSuv();
            case "pickup" :
                recargo += recargoAntiguedad.getPickup();
            case "furgoneta" :
                recargo += recargoAntiguedad.getFurgoneta();
        }
        sumaFinal = sumaFinal + ((sumaFinal * (recargo - descuento))/ 100);

        return sumaFinal;
    }

    public boolean calcularMontoTotal() {
        HistorialReparacionEntity historialReparacion = new HistorialReparacionEntity();
        Long montoTotal = montoTotal(historialReparacion);
        historialReparacion.setMontoTotal(montoTotal);

        historialReparacionRepository.save(historialReparacion);

        return true;
    }

}
