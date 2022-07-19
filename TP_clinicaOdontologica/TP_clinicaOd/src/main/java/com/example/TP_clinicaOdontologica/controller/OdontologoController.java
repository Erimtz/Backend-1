package com.example.TP_clinicaOdontologica.controller;

import com.example.TP_clinicaOdontologica.model.Odontologo;
import com.example.TP_clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Integer id){
        Odontologo odontologo = odontologoService.buscar(id);
        if(odontologo !=null){
            return ResponseEntity.ok(odontologo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        if (odontologoService.buscar(id) != null){
            odontologoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }


    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizar(odontologo));
    }

}
