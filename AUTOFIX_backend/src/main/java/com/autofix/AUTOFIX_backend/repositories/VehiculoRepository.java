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
    List<VehiculoEntity> findByKilometros(Long kilometros);
    List<VehiculoEntity> findByNAsientos(int NAsientos);

    @Query(value = "SELECT * FROM vehiculo WHERE vehiculo.año_fabricacion BETWEEN :inicioAño AND :finAño", nativeQuery = true)
    List<VehiculoEntity> findByAñoFabricacionBetween(@Param("inicioAño") Integer inicioAño, @Param("finAño") Integer finAño);

    @Query(value = "SELECT * FROM vehiculo WHERE vehiculo.kilometros BETWEEN :inicioK AND :finK", nativeQuery = true)
    List<VehiculoEntity> findByKilometrosBetween(@Param("inicioK") Long inicioK, @Param("finK") Long finK);

    @Query(value = "SELECT * FROM vehiculo WHERE vehiculo.NAsientos BETWEEN :inicioAsientos AND :finAsientos", nativeQuery = true)
    List<VehiculoEntity> findByNAsientosBetween(@Param("inicioAsientos") Integer incioAsientos, @Param("finAsientos") Integer finAsientos);

    boolean existsVehiculoByPatente(String patente);

}
