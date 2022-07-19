package com.example.clinica_MartinezErika.service;

import com.example.clinica_MartinezErika.dao.impl.IDao;
import com.example.clinica_MartinezErika.model.Turno;

import java.util.List;


public class TurnoService {

    private static IDao<Turno> turnoRepository;

    public TurnoService(IDao<Turno> turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public static List<Turno> buscarTodos(){
        return turnoRepository.buscarTodos();
    }

    public Turno registrarTurno(Turno turno){
        return turnoRepository.guardar(turno);
    }

    public Turno actualizar(Turno turno){
        return turnoRepository.actualizar(turno);
    }


    public Object eliminar(Turno turno) {
    }

    public Object buscar(Integer id) {
    }
}
