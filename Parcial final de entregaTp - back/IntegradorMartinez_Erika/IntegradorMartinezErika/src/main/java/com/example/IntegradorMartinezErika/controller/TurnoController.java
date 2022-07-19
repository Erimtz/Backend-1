package com.example.IntegradorMartinezErika.controller;


import com.example.IntegradorMartinezErika.exceptions.BadRequestException;
import com.example.IntegradorMartinezErika.exceptions.ResourceNotFoundException;
import com.example.IntegradorMartinezErika.model.Turno;
import com.example.IntegradorMartinezErika.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;


    @GetMapping
    public ResponseEntity<List<Turno>> buscar(){
       return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno) throws BadRequestException {
        return ResponseEntity.ok(turnoService.guardar(turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        turnoService.eliminar(id);
        return ResponseEntity.ok().body("Eliminado");
    }

    @PutMapping
    public ResponseEntity<Turno> turnoActualizado(@RequestBody Turno turno) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.actualizar(turno));
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarError(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}