package com.example.IntegradorMartinezErika.service;


import com.example.IntegradorMartinezErika.model.Domicilio;
import com.example.IntegradorMartinezErika.model.Paciente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class PacienteIntegracionTest {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MockMvc mockMvc;

    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente("Micaela", "Perez", "99999999", new Date(), domicilio1));
    }


    @Test
    public void buscarTodosLosPacientes() throws Exception {
        //Cargar pacientes
        this.cargarDataSet();
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/pacientes"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void buscarPacientePorId() throws Exception {
        //Cargar un paciente
        this.cargarDataSet();
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}","1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
        //Assert.assertEquals("application/json",response.getResponse().getContentType());
    }

}