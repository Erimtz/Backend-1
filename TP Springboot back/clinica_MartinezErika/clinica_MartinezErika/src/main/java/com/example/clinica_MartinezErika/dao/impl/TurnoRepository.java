package com.example.clinica_MartinezErika.dao.impl;

import com.example.clinica_MartinezErika.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoRepository implements IDao<Turno> {

    private List<Turno> turnos = new ArrayList<>();


    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        for (Turno turno : turnos) {
            if (turno.getId().equals(id)) {
                return turno;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        for (Turno turno : turnos) {
            if (turno.getId().equals(id)) {
                turnos.remove(turno);
                break;
            }
        }


        @Override
        public List<Turno> buscarTodos () {
            return null;
        }

        @Override
        public Turno actualizar (Turno t){
            for (Turno turno : turnos) {
                if (turno.equals(t)) {
                    turnos.remove(turno);
                    turnos.add(t);
                }
                return turnos.t;
            }
        }
    }
}


