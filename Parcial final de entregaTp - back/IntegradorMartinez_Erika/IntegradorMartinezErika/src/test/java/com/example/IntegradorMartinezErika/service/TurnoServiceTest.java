package com.example.IntegradorMartinezErika.service;


import com.example.IntegradorMartinezErika.exceptions.BadRequestException;
import com.example.IntegradorMartinezErika.exceptions.ResourceNotFoundException;
import com.example.IntegradorMartinezErika.model.Domicilio;
import com.example.IntegradorMartinezErika.model.Odontologo;
import com.example.IntegradorMartinezErika.model.Paciente;
import com.example.IntegradorMartinezErika.model.Turno;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TurnoServiceTest {

    private static Logger logger = Logger.getLogger(String.valueOf(TurnoService.class));

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void guardarTurno() throws BadRequestException, ResourceNotFoundException {
        logger.info("Guardando turno");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo("ABC123","Andres","Monterrosa"));

        Turno turno = new Turno(123,paciente, odontologo, new Date());
        Turno turnoCreado = turnoService.guardar(turno);
        Assert.assertNotNull(turnoService.buscar(turnoCreado.getId()));
    }

    @Test
    public void buscarPorId() throws BadRequestException, ResourceNotFoundException {
        logger.info("Buscando turno por id: ");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo("ABC123","Andres","Monterrosa"));

        Turno turno = new Turno(1234,paciente, odontologo, new Date());
        Turno turno1 = turnoService.guardar(turno);

        Turno turnoABuscar = turnoService.buscar(turno1.getId());
        Assert.assertNotNull(turnoABuscar);

        Assert.assertEquals("Andres", turnoABuscar.getOdontologo().getNombre());
    }

    @Test
    public void eliminarTurnoTest() throws BadRequestException, ResourceNotFoundException {
        logger.error("eliminando un turno");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo("ABC123","Andres","Monterrosa"));

        Turno turno1 = turnoService.guardar(new Turno(12345,paciente, odontologo, new Date()));

        turnoService.eliminar(turno1.getId());

        assertNull(turnoService.buscar(turno1.getId()));
    }

    @Test
    public void actualizarTurnoTest() throws BadRequestException, ResourceNotFoundException {
        logger.info("Actualizando un nuevo turno");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo("ABC123","Andres","Monterrosa"));

        Turno turno = new Turno(1234567,paciente, odontologo, new Date());
        Turno turno1 = turnoService.guardar(turno);

        odontologo.setNombre("Felipe");
        Odontologo odontologoActualizado = odontologoService.actualizar(odontologo);
        turno1.setOdontologo(odontologoActualizado);


        Turno turnoActualizado = turnoService.actualizar(turno1);
        Assert.assertEquals("Felipe", turnoActualizado.getOdontologo().getNombre());
    }

    @Test
    public void listarTodos() throws BadRequestException, ResourceNotFoundException {
        logger.info("Mostrando la lista de turnos");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo("ABC123","Andres","Monterrosa"));

        Turno turno = new Turno(123456,paciente, odontologo, new Date());
        Turno turnoCreado = turnoService.guardar(turno);
        List<Turno> turnos = turnoService.buscarTodos();
        Assert.assertFalse(turnos.isEmpty());
    }
}
