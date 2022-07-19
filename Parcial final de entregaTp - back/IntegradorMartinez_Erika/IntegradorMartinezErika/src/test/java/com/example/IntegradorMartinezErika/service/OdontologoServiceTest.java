package com.example.IntegradorMartinezErika.service;


import com.example.IntegradorMartinezErika.exceptions.BadRequestException;
import com.example.IntegradorMartinezErika.exceptions.ResourceNotFoundException;
import com.example.IntegradorMartinezErika.model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    private static Logger logger = Logger.getLogger(String.valueOf(OdontologoService.class));

    @Autowired
    private OdontologoService odontologoService;


    @Test
    public void actualizar() {
        logger.info("Actualizando un nuevo odontologo");
        Odontologo odontologo = new Odontologo(5, "444", "CABA", "Paez");
        odontologoService.guardar(new Odontologo("555", "Tomas", "Pereyra"));
        Odontologo odontologo1 = new Odontologo(6,"222", "Pedro","Martin");
        Odontologo o1 = odontologoService.guardar(new Odontologo(4, "777", "María", "Hernandez"));
    }


    @Test
    public void agregarYBuscarOdontologoTest() {
        logger.info("Agregando y buscando un nuevo odontologo");
        Odontologo odontologo = new Odontologo(8, "333", "Sofía", "Palacio");
        Odontologo odontologo1 = odontologoService.guardar(new Odontologo(8, "333", "Sofía", "Palacio"));
        Assert.assertNotNull(odontologoService.buscar(odontologo1.getId()));
    }


    @Test
    public void eliminarOdontologoTest() throws ResourceNotFoundException {
        logger.error("eliminando un odontologo");
        Odontologo odontologo = odontologoService.guardar(new Odontologo("002", "Martin", "Rodriguez"));
        odontologoService.eliminar(odontologo.getId());

        assertNull(odontologoService.buscar(odontologo.getId()));

    }

    @Test
    public void traerTodos() {
        logger.info("Mostrando la lista de odontologos");
        Odontologo odontologo = odontologoService.guardar(new Odontologo("002", "Martin", "Rodriguez"));

        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        System.out.println(odontologos);
    }

    @Test
    public void buscarPorId() throws BadRequestException, ResourceNotFoundException {
        Odontologo odontologo = odontologoService.guardar(new Odontologo("ABC123","Andres","Monterrosa"));
        Odontologo odontologoABuscar = odontologoService.buscar(odontologo.getId());
        assertNotNull(odontologoABuscar);
        assertEquals("Andres", odontologoABuscar.getNombre());
    }

}





