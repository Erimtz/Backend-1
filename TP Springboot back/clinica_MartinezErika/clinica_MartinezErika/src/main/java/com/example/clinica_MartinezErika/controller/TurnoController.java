package com.example.clinica_MartinezErika.controller;

import com.example.clinica_MartinezErika.dao.impl.TurnoRepository;
import com.example.clinica_MartinezErika.model.Turno;
import com.example.clinica_MartinezErika.service.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService = new TurnoService(new TurnoRepository());

    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos() {
        return ResponseEntity.ok(TurnoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(Turno turno) {
        return ResponseEntity.ok(turnoService.registrarTurno(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(turnoService.buscar(id));

    }

    @DeleteMapping
    public ResponseEntity<Object> eliminar(Turno turno) {
        return ResponseEntity.ok(turnoService.eliminar(turno));

    }

    @PutMapping
    public ResponseEntity<Turno> actualizar(Turno turno) {
        return ResponseEntity.ok(turnoService.actualizar(turno));
    }

}
