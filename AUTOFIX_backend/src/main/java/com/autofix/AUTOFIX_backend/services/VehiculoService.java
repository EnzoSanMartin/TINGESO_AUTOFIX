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

    public ArrayList<VehiculoEntity> getMarcas(String marca) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByMarca(marca); }
    public ArrayList<VehiculoEntity> getModelos(String modelo) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByModelo(modelo); }
    public ArrayList<VehiculoEntity> getTipos(String tipo) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByTipo(tipo); }
    public ArrayList<VehiculoEntity> getTiposMotor(String tipoMotor) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByTipoMotor(tipoMotor); }
    public ArrayList<VehiculoEntity> getAñosF(int año) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByAñoFabricacion(año); }
    public ArrayList<VehiculoEntity> getKilometros(Long kilometros) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByKilometros(kilometros); }
    public ArrayList<VehiculoEntity> getAsientos(int asientos) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByNAsientos(asientos); }
    public ArrayList<VehiculoEntity> getAñosFBetween(int añoI, int añoF) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByAñoFabricacionBetween(añoI, añoF); }
    public ArrayList<VehiculoEntity> getKilometrosBetween(Long kilometrosI, Long kilometrosF) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByKilometrosBetween(kilometrosI, kilometrosF); }
    public ArrayList<VehiculoEntity> getAsientosBetween(int asientosI, int asientosF) {return (ArrayList<VehiculoEntity>) vehiculoRepository.findByNAsientosBetween(asientosI, asientosF); }

    public VehiculoEntity saveVehiculo(VehiculoEntity vehiculo) {return vehiculoRepository.save(vehiculo); }
    public VehiculoEntity updateVehiculo(VehiculoEntity vehiculo) {return vehiculoRepository.save(vehiculo); }

    public VehiculoEntity getVehiculoById(Long id) {return vehiculoRepository.findById(id).get(); }
    public VehiculoEntity getVehiculoByPatente(String patente) {return  vehiculoRepository.findByPatente(patente); }

    public boolean existsVehiculoByPatente(String patente) {return vehiculoRepository.existsVehiculoByPatente(patente); } ;

    public boolean deleteVehiculo(Long id) throws Exception {
        try {
            vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }
}
