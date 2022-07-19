package com.company;

import com.company.dao.OdontologoDaoH2;
import com.company.model.Odontologo;
import com.company.service.OdontologoService;
import org.junit.Assert;

public class Main {
    public static void main(String[] args) {
        Odontologo odontologo = new Odontologo(8, 1234, "Ernesto", "Pérez");
        Odontologo odontologo2 = new Odontologo(9, 456, "Pepe", "Pérez");


        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

        odontologoService.crearTabla();

        Odontologo odontologo1 = odontologoService.guardarOdontologo(odontologo);
        odontologoService.guardarOdontologo(odontologo2);

        System.out.println(odontologoService.buscarTodos().size());


    }
}


