package com.example.IntegradorMartinezErika.service;

import com.example.IntegradorMartinezErika.exceptions.ResourceNotFoundException;
import com.example.IntegradorMartinezErika.model.Paciente;
import com.example.IntegradorMartinezErika.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class PacienteService {
    private PacienteRepository pacienteRepository;


    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteRepository.save(p);
    }

    public Paciente buscar(Integer id) {
        return pacienteRepository.findById(id).get();
    }


    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
       try{
           if (buscar(id) == null)
               throw new ResourceNotFoundException("No existe un paciente con el ID" + id);
           pacienteRepository.deleteById(id);
       }catch (NoSuchElementException exception){
           throw new ResourceNotFoundException("No existe un paciente con el ID" + id);
       }
    }

    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}
