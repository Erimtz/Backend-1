package com.example.TP_clinicaOdontologica.controller;


import com.example.TP_clinicaOdontologica.model.Paciente;
import com.example.TP_clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public Paciente buscar(@PathVariable Integer id){
        return pacienteService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){

        pacienteService.eliminar(id);
    }

    @GetMapping
    public List<Paciente> buscarTodos(){

        return pacienteService.buscarTodos();
    }

    @PostMapping
    public Paciente guardar(@RequestBody Paciente paciente){

        return pacienteService.guardar(paciente);
    }

    @PutMapping
    public Paciente actualizar(@RequestBody Paciente paciente){

        return pacienteService.actualizar(paciente);
    }
}

