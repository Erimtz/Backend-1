package com.example.IntegradorMartinezErika.service;


import com.example.IntegradorMartinezErika.exceptions.BadRequestException;
import com.example.IntegradorMartinezErika.exceptions.ResourceNotFoundException;
import com.example.IntegradorMartinezErika.model.Turno;
import com.example.IntegradorMartinezErika.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;


    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardar(Turno turno) throws BadRequestException {
        if (pacienteService.buscar(turno.getPaciente().getId()) == null  || odontologoService.buscar(turno.getOdontologo().getId()) == null)
            throw new BadRequestException("El paciente o el odontologo no existen");
        return turnoRepository.save(turno);
    }

    public Turno buscar(Integer id){
        Turno turno = null;
        Optional<Turno> optionalTurno = turnoRepository.findById(id);
        if (optionalTurno.isPresent()) {
            turno = optionalTurno.get();
        }
        return turno;
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {

        if (this.buscar( id) == null)
            throw new ResourceNotFoundException("No existe un turno con el ID" + id);
        turnoRepository.deleteById(id);
    }

    public Turno actualizar(Turno turno) throws ResourceNotFoundException {
        if (buscar(turno.getId()) == null) {
            throw new ResourceNotFoundException("No existe el turno con id:" + turno.getId());
        }else if (pacienteService.buscar(turno.getPaciente().getId()) == null) {
            throw new RuntimeException("No existe el paciente con el id: " + turno.getPaciente().getId());
        } else if (odontologoService.buscar(turno.getOdontologo().getId()) == null) {
            throw new ResourceNotFoundException("No existe el odontologo con id: " + turno.getOdontologo().getId());
        } else {
            return turnoRepository.save(turno);
        }
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> tratarError(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
