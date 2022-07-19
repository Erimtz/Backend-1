package com.example.TP_clinicaOdontologica.repository;

import com.example.TP_clinicaOdontologica.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Integer> {
    Domicilio guardar(Domicilio d);
    Domicilio buscar(Integer id);
    void eliminar(Integer id);
    List<Domicilio> buscarTodos();
    Domicilio actualizar(Domicilio d);
}
