package com.example.TP_clinicaOdontologica.repository;


import com.example.TP_clinicaOdontologica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
    Turno guardar(Turno t);
    Turno buscar(Integer id);
    void eliminar(Integer id);
    List<Turno> buscarTodos();
    Turno actualizar(Turno t);
}
