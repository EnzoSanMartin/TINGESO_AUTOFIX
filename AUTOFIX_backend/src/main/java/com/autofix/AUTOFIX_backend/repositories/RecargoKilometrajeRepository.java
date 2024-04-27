package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.RecargoKilometrajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecargoKilometrajeRepository extends JpaRepository<RecargoKilometrajeEntity, Long> {

    @Query(value = "SELECT * FROM recargoKilometraje WHERE recargoKilometraje.cotaInicial >= :kilometraje AND recargoKilometraje.cotafinal <= :kilometraje", nativeQuery = true)
    RecargoKilometrajeEntity findByKM(@Param("kiometraje") Long kilometraje);
}
