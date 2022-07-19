package com.example.IntegradorMartinezErika.service;

import com.example.IntegradorMartinezErika.exceptions.ResourceNotFoundException;
import com.example.IntegradorMartinezErika.model.Domicilio;
import com.example.IntegradorMartinezErika.model.Paciente;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    private static Logger logger = Logger.getLogger(String.valueOf(PacienteService.class));

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private DomicilioService domicilioService;


    //@BeforeClass
    public void cargarDataSet() {
        logger.info("Cargando data de paciente");
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente("Micaela", "Perez", "99999999", new Date(), domicilio1));
    }


    @Test
    public void agregarYBuscarPacienteTest() {
        logger.info("Agregando y buscando un nuevo paciente");
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }


    @Test
    public void eliminarPacienteTest() throws ResourceNotFoundException {
        logger.error("eliminando un paciente");
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));

        pacienteService.eliminar(p.getId());

        assertThrows(NoSuchElementException.class, () ->pacienteService.buscar(p.getId()));
    }

    @Test
    public void traerTodos() {
        logger.info("Mostrando la lista de pacientes");
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }

}
