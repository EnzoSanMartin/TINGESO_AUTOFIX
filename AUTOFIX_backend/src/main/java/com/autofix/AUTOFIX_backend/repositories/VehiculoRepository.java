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
    public VehiculoEntity findByMarca(String marca);

    /*List<EmployeeEntity> findBySalaryGreaterThan(int salary);
    List<EmployeeEntity> findByChildrenBetween(Integer startChildren, Integer endChildren);
    @Query(value = "SELECT * FROM employees WHERE employees.rut = :rut", nativeQuery = true)
    EmployeeEntity findByRutNativeQuery(@Param("rut") String rut);*/


}
