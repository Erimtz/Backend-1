package com.example.clinica_MartinezErika.controller;

import com.example.clinica_MartinezErika.dao.impl.OdontologoDaoH2;
import com.example.clinica_MartinezErika.model.Odontologo;
import com.example.clinica_MartinezErika.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService OdontologoService= new OdontologoService(new OdontologoDaoH2());

    @GetMapping("/odontologos/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(OdontologoService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(OdontologoService.guardar(odontologo)) ;
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        //return pacienteService.actualizar(paciente);
        ResponseEntity<Odontologo> response;
        //Verificar si el ID es distinto de NULL y si el paciente existe
        if (Odontologo.getId() != null && OdontologoService.buscar(odontologo.getId()) != null){
            response= ResponseEntity.ok(OdontologoService.actualizar(odontologo));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        OdontologoService.eliminar(id);

        response= ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(OdontologoService.buscarTodos());
    }


}
