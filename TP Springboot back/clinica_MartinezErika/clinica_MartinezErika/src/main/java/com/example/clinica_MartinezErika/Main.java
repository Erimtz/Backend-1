package com.example.clinica_MartinezErika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    // Pruebas si usar JUNIT
    //PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    //Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
    //Paciente paciente= new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio);
    //Paciente p = pacienteService.guardar(paciente);

    //Odontologo odontologo = new Odontologo(8, 1234, "Ernesto", "Pérez");
    //Odontologo odontologo2 = new Odontologo(9, 456, "Pepe", "Pérez");


    //OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    //odontologoService.crearTabla();

    //Odontologo odontologo1 = odontologoService.guardarOdontologo(odontologo);
    //odontologoService.guardarOdontologo(odontologo2);

    //System.out.println(odontologoService.buscarTodos().size());

}

