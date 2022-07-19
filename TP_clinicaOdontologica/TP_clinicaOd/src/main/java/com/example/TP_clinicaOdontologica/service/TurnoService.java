package com.example.TP_clinicaOdontologica.service;


import com.example.TP_clinicaOdontologica.model.Turno;
import com.example.TP_clinicaOdontologica.repository.ITurnoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TurnoService {

    private static ITurnoRepository iTurnoRepository;

    public TurnoService(ITurnoRepository iTurnoRepository) {
        this.iTurnoRepository = iTurnoRepository;
    }

    public static Turno guardar(Turno turno) {
        turno.setFecha(new Date());
        return iTurnoRepository.guardar(turno);
    }

    public static void eliminar(Integer id) {
        iTurnoRepository.eliminar(id);
    }

    public static Turno buscar(Integer id) {
        return iTurnoRepository.buscar(id);
    }

    public static List<Turno> buscarTodos() {
        return iTurnoRepository.buscarTodos();
    }

    public static Turno actualizar(Turno turno) {
        return iTurnoRepository.actualizar(turno);
    }
}
