package com.autofix.AUTOFIX_backend.controllers;

import com.autofix.AUTOFIX_backend.entities.VehiculoEntity;
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

@WebMvcTest(VehiculoController.class)
public class VehiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehiculoService vehiculoService;

    @Test
    public void listVehiculos_ShouldReturnVehiculos() throws Exception {
        VehiculoEntity vehiculo1 = new VehiculoEntity(1L, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);
        VehiculoEntity vehiculo2 = new VehiculoEntity(2L, "ACDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);

        List<VehiculoEntity> vehiculoList = new ArrayList<>(Arrays.asList(vehiculo1, vehiculo2));

        given(vehiculoService.getVehiculos()).willReturn((ArrayList<VehiculoEntity>) vehiculoList);

        mockMvc.perform(get("/autofix/v1/vehiculos/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].patente", is("BCDD34")))
                .andExpect(jsonPath("$[1].patente", is("ACDD34")));
    }


    @Test
    public void updateVehiculo_ShouldReturnUpdatedVehiculo() throws Exception {
        VehiculoEntity updatedEmployee = new VehiculoEntity(1L, "BCDD34", "toyota", "A1", "sedan", "gasolina", 2000, 4, 0L);

        given(vehiculoService.updateVehiculo(Mockito.any(VehiculoEntity.class))).willReturn(updatedEmployee);

        String vehiculoJson = """
            {
                "id": 1,
                "patente": "BCDD34",
                "marca": "toyota",
                "modelo": "A1",
                "tipo": "sedan",
                "tipoMotor": "gasolina",
                "añoFabricacion": 2000,
                "NAsientos": 4,
                "kilometros": 0
            }
            """;


        mockMvc.perform(put("/autofix/v1/vehiculos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vehiculoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patente", is("BCDD34")));
    }

    @Test
    public void deleteVehiculoById_ShouldReturn204() throws Exception {
        when(vehiculoService.deleteVehiculo(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/autofix/v1/vehiculos/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}
