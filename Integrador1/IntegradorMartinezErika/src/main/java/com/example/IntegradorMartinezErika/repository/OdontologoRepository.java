package com.example.IntegradorMartinezErika.repository;

import com.example.IntegradorMartinezErika.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
