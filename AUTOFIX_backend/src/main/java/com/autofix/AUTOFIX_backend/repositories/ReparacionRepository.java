package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, Long> {
    public ReparacionEntity findByNombre(String nombre);

    @Modifying
    @Query(value = "UPDATE reparacion SET reparacion.precioGasolina =: precioNew WHERE reparacion.id = :idEntry", nativeQuery = true)
    public Long updatePrecioGasolina(@Param("precioNew") Long precioNew, @Param("idEntry") Long idEntry);

    @Query(value = "UPDATE reparacion SET reparacion.precioDiesel =:precioNew WHERE reparacion.id = :idEntry", nativeQuery = true)
    public Long updatePrecioDiesel(@Param("precioNew") Long precioNew, @Param("idEntry") Long idEntry);

    @Query(value = "UPDATE reparacion SET reparacion.precioHibrido =:precioNew WHERE reparacion.id = :idEntry", nativeQuery = true)
    public Long updatePrecioHibrido(@Param("precioNew") Long precioNew, @Param("idEntry") Long idEntry);

    @Query(value = "UPDATE reparacion SET reparacion.precioElectrico =:precioNew WHERE reparacion.id = :idEntry", nativeQuery = true)
    public Long updatePrecioEletrico(@Param("precioNew") Long precioNew, @Param("idEntry") Long idEntry);


    @Query(value = "SELECT * FROM reparacion WHERE reparacion.precioGasolina BETWEEN :precioI AND :precioF", nativeQuery = true)
    List<ReparacionEntity> findByPrecioGasolinaBetween(@Param("precioI") Long precioI, @Param("precioF") Long precioF);

    @Query(value = "SELECT * FROM reparacion WHERE reparacion.precioDiesel BETWEEN :precioI AND :precioF", nativeQuery = true)
    List<ReparacionEntity> findByPrecioDieselBetween(@Param("precioI") Long precioI, @Param("precioF") Long precioF);

    @Query(value = "SELECT * FROM reparacion WHERE reparacion.precioHibrido BETWEEN :precioI AND :precioF", nativeQuery = true)
    List<ReparacionEntity> findByPrecioHibridoBetween(@Param("precioI") Long precioI, @Param("precioF") Long precioF);

    @Query(value = "SELECT * FROM reparacion WHERE reparacion.precioElectrico BETWEEN :precioI AND :precioF", nativeQuery = true)
    List<ReparacionEntity> findByPrecioElectricoBetween(@Param("precioI") Long precioI, @Param("precioF") Long precioF);


}
