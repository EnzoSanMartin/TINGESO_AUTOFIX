package com.autofix.AUTOFIX_backend.controllers;

import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
import com.autofix.AUTOFIX_backend.services.ReparacionService;
import com.autofix.AUTOFIX_backend.services.VehiculoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReparacionController.class)
public class ReparacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReparacionService reparacionService;

    @Test
    public void listReparaciones_ShouldReturnReparaciones() throws Exception {
        ReparacionEntity reparacion1 = new ReparacionEntity(1L,
                "Reparaciones del Sistema de Frenos",
                "A", 120000L, 120000L, 180000L, 220000L);
        ReparacionEntity reparacion2 = new ReparacionEntity(1L,
                "Servicio del Sistema de Refrigeración",
                "B", 130000L , 130000L, 190000L, 230000L);

        List<ReparacionEntity> reparacionList = new ArrayList<>(Arrays.asList(reparacion1, reparacion2));

        given(reparacionService.getReparaciones()).willReturn((ArrayList<ReparacionEntity>) reparacionList);

        mockMvc.perform(get("/autofix/v1/reparaciones/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("Reparaciones del Sistema de Frenos")))
                .andExpect(jsonPath("$[1].nombre", is("Servicio del Sistema de Refrigeración")));
    }


    @Test
    public void updateReparacion_ShouldReturnUpdatedReparacion() throws Exception {
        ReparacionEntity updateReparacion = new ReparacionEntity(1L,
                "Reparaciones del Sistema de Frenos",
                "A", 120000L, 120000L, 180000L, 220000L);

        given(reparacionService.updateReparacion(Mockito.any(ReparacionEntity.class))).willReturn(updateReparacion);

        String vehiculoJson = """
            {
                "id": 1,
                "nombre": "Reparaciones del Sistema de Frenos",
                "descripcion": "A",
                "precioGasolina": 120000,
                "precioDiesel": 120000,
                "precioHibrido": 180000,
                "precioElectrico": 220000
            }
            """;


        mockMvc.perform(put("/autofix/v1/reparaciones/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vehiculoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Reparaciones del Sistema de Frenos")));
    }

    @Test
    public void deleteReparacionById_ShouldReturn204() throws Exception {
        when(reparacionService.deleteReparacion(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/autofix/v1/reparaciones/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}
