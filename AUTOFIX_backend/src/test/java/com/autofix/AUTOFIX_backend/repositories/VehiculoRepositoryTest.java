package com.autofix.AUTOFIX_backend.repositories;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class VehiculoRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VehiculoRepository vehiculoRepository;


    @Test
    public void whenFindByPatente_thenReturnVehiculo() {
        // given
        VehiculoEntity vehiculo = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        entityManager.persistAndFlush(vehiculo);

        // when
        VehiculoEntity found = vehiculoRepository.findByPatente(vehiculo.getPatente());

        // then
        assertThat(found.getPatente()).isEqualTo(vehiculo.getPatente());
    }

    @Test
    public void whenFindByMarca_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "BCDD35", "toyota", "A1", "hatchback", "gasolina", 2000, 4, 0L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByMarca("toyota");

        // then
        assertThat(foundVehiculos).hasSize(2).extracting(VehiculoEntity::getMarca).containsOnly("toyota");
    }

    @Test
    public void whenFindByModelo_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "BCDD35", "toyota", "A1", "hatchback", "gasolina", 2000, 4, 0L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByModelo("A1");

        // then
        assertThat(foundVehiculos).hasSize(2).extracting(VehiculoEntity::getModelo).containsOnly("A1");
    }

    @Test
    public void whenFindByTipo_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "BLDD35", "honda", "A1", "sedan", "gasolina", 2000, 4, 0L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByTipo("sedan");

        // then
        assertThat(foundVehiculos).hasSize(2).extracting(VehiculoEntity::getTipo).containsOnly("sedan");
    }

    @Test
    public void whenFindByTipoMotor_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "BLDD35", "honda", "A1", "sedan", "gasolina", 2000, 4, 0L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByTipoMotor("gasolina");

        // then
        assertThat(foundVehiculos).hasSize(2).extracting(VehiculoEntity::getTipoMotor).containsOnly("gasolina");
    }

    @Test
    public void whenFindByAñoFabricacion_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "BLDD35", "honda", "A1", "sedan", "gasolina", 2000, 4, 0L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByAñoFabricacion(2000);

        // then
        assertThat(foundVehiculos).hasSize(2).extracting(VehiculoEntity::getAñoFabricacion).containsOnly(2000);
    }

    @Test
    public void whenFindByKilometros_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "BLDD35", "honda", "A1", "sedan", "gasolina", 2000, 4, 0L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByKilometros(0L);

        // then
        assertThat(foundVehiculos).hasSize(2).extracting(VehiculoEntity::getKilometros).containsOnly(0L);
    }

    @Test
    public void whenFindByAsientos_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "BLDD35", "honda", "A1", "sedan", "gasolina", 2000, 4, 0L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByNAsientos(4);

        // then
        assertThat(foundVehiculos).hasSize(2).extracting(VehiculoEntity::getNAsientos).containsOnly(4);
    }

    @Test
    public void whenFindByAñoFabricacionBetween_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "ACDD34", "toyota", "A1", "sedan", "gasolina", 2002, 4, 0L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByAñoFabricacionBetween(2000, 2001);

        // then
        assertThat(foundVehiculos).hasSize(1).extracting(VehiculoEntity::getPatente).containsOnly("BCDD34");
    }

    @Test
    public void whenFindByKilometrosBetween_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "ACDD34", "toyota", "A1", "sedan", "gasolina", 2002, 4, 10L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByKilometrosBetween(0L, 5L);

        // then
        assertThat(foundVehiculos).hasSize(1).extracting(VehiculoEntity::getPatente).containsOnly("BCDD34");
    }

    @Test
    public void whenFindByAsientosBetween_thenReturnVehiculos() {
        // given
        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "ACDD34", "toyota", "A1", "sedan", "gasolina", 2002, 5, 10L);
        entityManager.persist(vehiculo1);
        entityManager.persist(vehiculo2);
        entityManager.flush();

        // when
        List<VehiculoEntity> foundVehiculos = vehiculoRepository.findByNAsientosBetween(1, 4);

        // then
        assertThat(foundVehiculos).hasSize(1).extracting(VehiculoEntity::getPatente).containsOnly("BCDD34");
    }

}
