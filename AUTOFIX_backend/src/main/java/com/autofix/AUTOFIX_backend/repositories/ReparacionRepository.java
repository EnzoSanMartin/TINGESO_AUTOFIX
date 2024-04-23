package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, Long> {
    public ReparacionEntity findByNombre(String nombre);

    @Query(value = "SELECT * FROM reparacion WHERE reparacion.precioGasolina BETWEEN :precioI AND :precioF", nativeQuery = true)
    List<ReparacionEntity> findByPrecioGasolinaBetween(@Param("precioI") Long precioI, @Param("precioF") Long precioF);

    @Query(value = "SELECT * FROM reparacion WHERE reparacion.precioDiesel BETWEEN :precioI AND :precioF", nativeQuery = true)
    List<ReparacionEntity> findByPrecioDieselBetween(@Param("precioI") Long precioI, @Param("precioF") Long precioF);

    @Query(value = "SELECT * FROM reparacion WHERE reparacion.precioHibrido BETWEEN :precioI AND :precioF", nativeQuery = true)
    List<ReparacionEntity> findByPrecioHibridoBetween(@Param("precioI") Long precioI, @Param("precioF") Long precioF);

    @Query(value = "SELECT * FROM reparacion WHERE reparacion.precioElectrico BETWEEN :precioI AND :precioF", nativeQuery = true)
    List<ReparacionEntity> findByPrecioElectricoBetween(@Param("precioI") Long precioI, @Param("precioF") Long precioF);


}
