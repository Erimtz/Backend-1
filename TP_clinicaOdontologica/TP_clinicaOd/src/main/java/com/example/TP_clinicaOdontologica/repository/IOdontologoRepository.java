package com.example.TP_clinicaOdontologica.repository;

import com.example.TP_clinicaOdontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
    Odontologo guardar(Odontologo o);
    Odontologo buscar(Integer id);
    void eliminar(Integer id);
    List<Odontologo> buscarTodos();
    Odontologo actualizar(Odontologo o);
}
