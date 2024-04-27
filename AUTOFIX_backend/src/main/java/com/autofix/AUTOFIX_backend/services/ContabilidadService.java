package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.HistorialReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.RecargoKilometrajeEntity;
import com.autofix.AUTOFIX_backend.entities.RecargoAntiguedadEntity;
import com.autofix.AUTOFIX_backend.entities.DescuentoCantReparacionesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Service
public class ContabilidadService {
    @Autowired
    VehiculoService vehiculoService;
    @Autowired
    ReparacionService reparacionService;
    @Autowired
    HistorialReparacionService historialReparacionService;
    @Autowired
    RecargoKilometrajeService recargoKilometrajeService;
    @Autowired
    RecargoAntiguedadService recargoAntiguedadService;
    @Autowired
    DescuentoCantReparacionesService descuentoCantReparacionesService;


    public Long sumReparaciones(HistorialReparacionEntity historialReparacion) {
        Long sumaFinal = 0L;
        List<Long> listaReparaciones = historialReparacion.getId_reparaciones();
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

        if ((diaIngreso == "lunes" || diaIngreso == "jueves") && (horaIngreso >= 9 && horaIngreso <= 12)) {
            descuento += 10;
        }

        Date fechaActual = historialReparacion.getIngresoTaller();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        calendar.add(Calendar.MONTH, -12);
        Date nuevaFecha = calendar.getTime();

        int cantReparaciones = historialReparacionService.getCountReparacionesByPatente(historialReparacion.getPatente(),nuevaFecha);
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



    //Recargo por Retraso en la Recogida del Vehículo: Se aplicará un recargo del 5% sobre
//el monto total de la reparación por cada día de retraso en la recogida del vehículo, contando
//desde la fecha en que este esté listo para ser entregado.

    //long fechaInicialMs = fechaInicial.getTime();
    //long fechaFinalMs = fechaFinal.getTime();
    //long diferencia = fechaFinalMs - fechaInicialMs;
    //double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
    //long diferenciaEnDias = TimeUnit.DAYS.convert(diferenciaEnMilisegundos, TimeUnit.MILLISECONDS);
}
