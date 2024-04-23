package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService {
    @Autowired
    VehiculoRepository vehiculoRepository;

    public ArrayList<VehiculoEntity> getVehiculos() {return (ArrayList<VehiculoEntity>) vehiculoRepository.findAll(); }
    public VehiculoEntity saveVehiculo(VehiculoEntity vehiculo) {return vehiculoRepository.save(vehiculo); }
    public VehiculoEntity getVehiculoById(Long id) {return vehiculoRepository.findById(id).get(); }
    public VehiculoEntity updateVehiculo(VehiculoEntity vehiculo) {return vehiculoRepository.save(vehiculo); }
    public VehiculoEntity getVehiculoByPatente(String patente) {return  vehiculoRepository.findByPatente(patente); }

    public boolean deleteVehiculo(Long id) throws Exception {
        try {
            vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }
}
