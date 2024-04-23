package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {
    public VehiculoEntity findByPatente(String patente);
    List<VehiculoEntity> findByMarca(String marca);
    List<VehiculoEntity> findByModelo(String modelo);
    List<VehiculoEntity> findByTipo(String tipo);
    List<VehiculoEntity> findByTipoMotor(String tipoMotor);
    List<VehiculoEntity> findByAñoFabricacion(int añoFabricacion);
    List<VehiculoEntity> findByKilometros(double kilometros);
    List<VehiculoEntity> findByNAsientos(int NAsientos);
    List<VehiculoEntity> findByAñoFabricacionBetween(Integer inicioAño, Integer finAño);
    List<VehiculoEntity> findByKilometrosBetween(Double inicioK, Double finK);
    List<VehiculoEntity> findByNAsientosBetween(Integer incioAsientos, Integer finAsientos);


    /*List<EmployeeEntity> findBySalaryGreaterThan(int salary);
    List<EmployeeEntity> findByChildrenBetween(Integer startChildren, Integer endChildren);
    @Query(value = "SELECT * FROM employees WHERE employees.rut = :rut", nativeQuery = true)
    EmployeeEntity findByRutNativeQuery(@Param("rut") String rut);*/


}
