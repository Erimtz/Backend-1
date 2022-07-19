package com.example.TP_clinicaOdontologica.service;


import com.example.TP_clinicaOdontologica.model.Paciente;
import com.example.TP_clinicaOdontologica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;


@Service
public class PacienteService {

    private IPacienteRepository iPacienteRepository;

    @Autowired
    public PacienteService(IPacienteRepository iPacienteRepository) {
        this.iPacienteRepository = iPacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return iPacienteRepository.guardar(p);
    }

    public void eliminar(Integer id) {

        iPacienteRepository.eliminar(id);
    }

    public Paciente buscar(Integer id) {

        return iPacienteRepository.buscar(id);
    }

    public List<Paciente> buscarTodos() {

        return iPacienteRepository.buscarTodos();
    }

    public Paciente actualizar(Paciente p) {

        return iPacienteRepository.actualizar(p);
    }

}
