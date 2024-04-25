package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReparacionService {
    @Autowired
    ReparacionRepository reparacionRepository;

    public ArrayList<ReparacionEntity> getReparaciones () {return (ArrayList<ReparacionEntity>) reparacionRepository.findAll(); }

    public ArrayList<ReparacionEntity> getPrecioGasolinaBetween(long precioI, long precioF) {return (ArrayList<ReparacionEntity>) reparacionRepository.findByPrecioGasolinaBetween(precioI, precioF); }
    public ArrayList<ReparacionEntity> getPrecioDieselBetween(long precioI, long precioF) {return (ArrayList<ReparacionEntity>) reparacionRepository.findByPrecioDieselBetween(precioI, precioF); }
    public ArrayList<ReparacionEntity> getPrecioHibridoBetween(long precioI, long precioF) {return (ArrayList<ReparacionEntity>) reparacionRepository.findByPrecioHibridoBetween(precioI, precioF); }
    public ArrayList<ReparacionEntity> getPrecioElectricoBetween(long precioI, long precioF) {return (ArrayList<ReparacionEntity>) reparacionRepository.findByPrecioElectricoBetween(precioI, precioF); }

    public ReparacionEntity saveReparacion(ReparacionEntity reparacion) {return reparacionRepository.save(reparacion); }
    public ReparacionEntity updateReparacion(ReparacionEntity reparacion) {return reparacionRepository.save(reparacion); }
    public void updatePrecioGasolina(Long precioNew, Long idEntry ) {reparacionRepository.updatePrecioGasolina(precioNew, idEntry) ;}
    public void updatePrecioDiesel(Long precioNew, Long idEntry ) {reparacionRepository.updatePrecioDiesel(precioNew, idEntry) ;}
    public void updatePrecioHibrido(Long precioNew, Long idEntry ) {reparacionRepository.updatePrecioHibrido(precioNew, idEntry) ;}
    public void updatePrecioElectrico(Long precioNew, Long idEntry ) {reparacionRepository.updatePrecioEletrico(precioNew, idEntry) ;}

    public ReparacionEntity getReparacionById(Long id) {return reparacionRepository.findById(id).get(); }
    public ReparacionEntity getReparacionByNombre(String nombre) {return reparacionRepository.findByNombre(nombre); }

    public boolean deleteReparacion(Long id) throws Exception {
        try {
            reparacionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }
}
