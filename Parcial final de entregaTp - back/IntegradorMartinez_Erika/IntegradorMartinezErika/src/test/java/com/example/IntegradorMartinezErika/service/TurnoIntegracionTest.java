package com.example.IntegradorMartinezErika.service;


import com.example.IntegradorMartinezErika.model.Domicilio;
import com.example.IntegradorMartinezErika.model.Odontologo;
import com.example.IntegradorMartinezErika.model.Paciente;
import com.example.IntegradorMartinezErika.model.Turno;
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
public class TurnoIntegracionTest {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private MockMvc mockMvc;


    public void cargarDataSet() throws Exception {
        //Se registrar Paciente y Odontologo
        Domicilio dom = new Domicilio("Av Santa fe2", "444", "CABA", "Buenos Aires");
       // Domicilio domicilio = domicilioService.guardar(dom);
        Paciente paciente = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), dom));
        Odontologo odontologo = odontologoService.guardar(new Odontologo("ABC123","Andres","Monterrosa"));
        //Se registra un Turno
        Turno turno= new Turno(321, paciente, odontologo, new Date());
        turnoService.guardar(turno);
    }

    @Test
    public void listarTurnos() throws Exception{
        //Carga un turno
        this.cargarDataSet();
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/turnos"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

}
