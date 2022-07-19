package com.example.IntegradorMartinezErika.repository;


import com.example.IntegradorMartinezErika.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
