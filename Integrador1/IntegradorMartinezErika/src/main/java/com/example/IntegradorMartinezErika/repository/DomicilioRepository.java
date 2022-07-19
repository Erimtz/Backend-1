package com.example.IntegradorMartinezErika.repository;


import com.example.IntegradorMartinezErika.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Integer> {
}