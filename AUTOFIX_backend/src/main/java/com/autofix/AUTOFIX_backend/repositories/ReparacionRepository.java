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

}
