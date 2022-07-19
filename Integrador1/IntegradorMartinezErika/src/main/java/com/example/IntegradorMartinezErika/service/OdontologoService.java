package com.example.IntegradorMartinezErika.service;

import com.example.IntegradorMartinezErika.exceptions.BadRequestException;
import com.example.IntegradorMartinezErika.exceptions.ResourceNotFoundException;
import com.example.IntegradorMartinezErika.model.Odontologo;
import com.example.IntegradorMartinezErika.repository.OdontologoRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class OdontologoService {
    private OdontologoRepository odontologoRepository;


    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Odontologo buscar(Integer id) {
        Odontologo odontologo = null;
        Optional<Odontologo> optionalOdontologo = odontologoRepository.findById(id);
        if (optionalOdontologo.isPresent()) {
            odontologo = optionalOdontologo.get();
        }
        return odontologo;
    }

    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {

        if (this.buscar(id) == null) {
            throw new ResourceNotFoundException("No existe un odontologo con el ID:" + id);
        }
        odontologoRepository.deleteById(id);
    }

    public Odontologo actualizar(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
}