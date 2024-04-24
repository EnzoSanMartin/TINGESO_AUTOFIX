package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.HistorialReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface HistorialReparacionRepository extends JpaRepository<HistorialReparacionEntity, Long> {

    List<HistorialReparacionEntity> findByIngresoTaller(Date ingresoTaller);
    List<HistorialReparacionEntity> findByDiaIngreso(String diaIngreso);
    List<HistorialReparacionEntity> findByIdReparacion(Long idReparacion);

    @Query("SELECT * FROM historialReparacion WHERE historialReparacion.ingresoTaller BETWEEN :fechaInicio AND :fechaFin")
    List<HistorialReparacionEntity> findByIngresoTallerBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT * FROM historialReparacion WHERE historialReparacion.terminoReparacion BETWEEN :fechaInicio AND :fechaFin")
    List<HistorialReparacionEntity> findByTerminoReparacionBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT * FROM historialReparacion WHERE historialReparacion.salidaTaller BETWEEN :fechaInicio AND :fechaFin")
    List<HistorialReparacionEntity> findBySalidaTallerBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);




}
