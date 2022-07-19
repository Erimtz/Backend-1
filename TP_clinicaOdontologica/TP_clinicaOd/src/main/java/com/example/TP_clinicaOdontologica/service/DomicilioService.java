package com.example.TP_clinicaOdontologica.service;


import com.example.TP_clinicaOdontologica.model.Domicilio;
import com.example.TP_clinicaOdontologica.repository.IDomicilioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {

    private IDomicilioRepository iDomicilioRepository;

    public DomicilioService(IDomicilioRepository iDomicilioRepository) {
        this.iDomicilioRepository = iDomicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        iDomicilioRepository.guardar(d);
        return d;
    }

    public void eliminar(Integer id){
        iDomicilioRepository.eliminar(id);
    }

    public Domicilio buscar(Integer id){
        return iDomicilioRepository.buscar(id);
    }

    public List<Domicilio> buscarTodos(){
        return iDomicilioRepository.buscarTodos();
    }

    public Domicilio actualizar(Domicilio domicilio){
        return iDomicilioRepository.actualizar(domicilio);
    }
}
