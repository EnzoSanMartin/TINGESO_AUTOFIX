package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.RecargoAntiguedadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecargoAntiguedadRepository extends JpaRepository<RecargoAntiguedadEntity, Long>{

    @Query(value = "SELECT * FROM recargoAntiguedad WHERE recargoAntiguedad.cotaInicial >= :año AND recargoAntiguedad.cotafinal <= :año", nativeQuery = true)
    RecargoAntiguedadEntity findByAño(@Param("año") int año);
}
