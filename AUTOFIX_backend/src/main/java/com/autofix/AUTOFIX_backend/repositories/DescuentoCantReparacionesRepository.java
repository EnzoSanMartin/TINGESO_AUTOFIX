package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.DescuentoCantReparacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescuentoCantReparacionesRepository extends JpaRepository<DescuentoCantReparacionesEntity, Long>{

    @Query(value = "SELECT * FROM descuentoCantReparaciones WHERE descuentoCantReparaciones.cotaInicial >= :cant AND descuentoCantReparaciones.cotafinal <= :cant", nativeQuery = true)
    DescuentoCantReparacionesEntity findByCant(@Param("cant") int cant);
}
