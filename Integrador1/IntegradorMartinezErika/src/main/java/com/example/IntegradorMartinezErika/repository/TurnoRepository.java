package com.example.IntegradorMartinezErika.repository;

import com.example.IntegradorMartinezErika.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}
