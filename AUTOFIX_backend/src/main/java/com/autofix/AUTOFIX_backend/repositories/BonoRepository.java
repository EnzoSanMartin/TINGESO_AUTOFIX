package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.BonoEntity;
import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonoRepository extends JpaRepository<BonoEntity, Long> {
    public BonoEntity findByMarca(String marca);
    public BonoEntity findByCantBonos(int cantBonos);
    public BonoEntity findByMonto(Long monto);

    @Query(value = "SELECT * FROM bono WHERE bono.cantBonos BETWEEN :cantI AND :cantF", nativeQuery = true)
    List<BonoEntity> findByCantBonosBetween(@Param("cantI") Integer cantI, @Param("cantF") Integer cantF);

    @Query(value = "SELECT * FROM bono WHERE bono.monto BETWEEN :montoI AND :montoF", nativeQuery = true)
    List<BonoEntity> findByMontoBetween(@Param("montoI") Long montoI, @Param("montoF") Long montoF);

}
