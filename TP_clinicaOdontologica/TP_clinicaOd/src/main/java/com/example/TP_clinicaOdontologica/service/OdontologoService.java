package com.example.TP_clinicaOdontologica.service;


import com.example.TP_clinicaOdontologica.model.Odontologo;
import com.example.TP_clinicaOdontologica.repository.IOdontologoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    private IOdontologoRepository iOdontologoRepository;

    public OdontologoService(IOdontologoRepository iOdontologoRepository) {
        this.iOdontologoRepository = iOdontologoRepository;
    }

    public Odontologo guardar(Odontologo odontologo){
        return iOdontologoRepository.guardar(odontologo);
    }

    public void eliminar(Integer id){
        iOdontologoRepository.eliminar(id);
    }

    public Odontologo buscar(Integer id){
        return iOdontologoRepository.buscar(id);
    }

    public List<Odontologo> buscarTodos(){
        return iOdontologoRepository.buscarTodos();
    }

    public Odontologo actualizar(Odontologo odontologo){
        return iOdontologoRepository.actualizar(odontologo);
    }

}
