package com.example.clinica_MartinezErika.service;


import com.example.clinica_MartinezErika.dao.impl.IDao;
import com.example.clinica_MartinezErika.model.Odontologo;
import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }

    public Odontologo buscar(Integer id) {
        return null;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologo;
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologo;
    }

    public void eliminar(Integer id) {
    }
}
