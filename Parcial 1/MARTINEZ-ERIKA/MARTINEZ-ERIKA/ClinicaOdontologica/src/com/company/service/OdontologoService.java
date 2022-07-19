package com.company.service;

import com.company.dao.IDao;
import com.company.model.Odontologo;

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

    public void crearTabla(){
        this.odontologoIDao.crearBD();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }

}
