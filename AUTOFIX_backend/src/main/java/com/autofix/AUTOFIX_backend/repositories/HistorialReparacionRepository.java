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
    List<HistorialReparacionEntity> findByIdReparaciones(List<Long> idReparacion);
    List<HistorialReparacionEntity> findByPatente(String patente);

    @Query(value = "SELECT * FROM historialReparacion WHERE historialReparacion.ingresoTaller BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    List<HistorialReparacionEntity> findByIngresoTallerBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query(value = "SELECT * FROM historialReparacion WHERE historialReparacion.terminoReparacion BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    List<HistorialReparacionEntity> findByTerminoReparacionBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query(value = "SELECT * FROM historialReparacion WHERE historialReparacion.salidaTaller BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    List<HistorialReparacionEntity> findBySalidaTallerBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query(value = "SELECT COUNT(*) FROM historialReparacion WHERE historialReparacion.patente = :patente AND historialReparacion.terminoReparacion >= :fecha", nativeQuery = true)
    int countReparacionesByPatente(@Param("patente") String patente, @Param("fecha") Date fecha);



}
