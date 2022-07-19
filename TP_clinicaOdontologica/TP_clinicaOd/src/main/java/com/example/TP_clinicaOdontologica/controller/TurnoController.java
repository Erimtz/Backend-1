package com.example.TP_clinicaOdontologica.controller;

import com.example.TP_clinicaOdontologica.model.Turno;
import com.example.TP_clinicaOdontologica.repository.ITurnoRepository;
import com.example.TP_clinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurnoController {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Integer id){
        Turno turno = TurnoService.buscar(id);
        if(turno !=null){
            return ResponseEntity.ok(turno);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        if (TurnoService.buscar(id) != null){
            TurnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(TurnoService.buscarTodos());
    }


    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno odontologo){
        return ResponseEntity.ok(TurnoService.guardar(odontologo));
    }

    @PutMapping
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno){
        return ResponseEntity.ok(TurnoService.actualizar(turno));
    }
}


