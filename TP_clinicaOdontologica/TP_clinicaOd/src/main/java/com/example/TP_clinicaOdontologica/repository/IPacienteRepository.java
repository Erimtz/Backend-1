package com.example.TP_clinicaOdontologica.repository;

import com.example.TP_clinicaOdontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

    Paciente guardar(Paciente p);
    Paciente buscar(Integer id);
    void eliminar(Integer id);
    List<Paciente> buscarTodos();
    Paciente actualizar(Paciente p);

}
