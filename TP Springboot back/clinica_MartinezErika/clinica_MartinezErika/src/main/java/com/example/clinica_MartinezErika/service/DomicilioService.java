package com.example.clinica_MartinezErika.service;


import com.example.clinica_MartinezErika.dao.impl.DomicilioDaoH2;
import com.example.clinica_MartinezErika.dao.impl.IDao;
import com.example.clinica_MartinezErika.model.Domicilio;
import java.util.List;


public class DomicilioService {
    private IDao<Domicilio> domicilioDao;

    public DomicilioService(DomicilioDaoH2 domicilioDao) {
        this.domicilioDao = domicilioDao;
    }
    public Domicilio guardar(Domicilio id){
        domicilioDao.guardar(id);
        return id;
    }
    public Domicilio buscar(Integer id){
        return domicilioDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicilioDao.buscarTodos();
    }
    public void eliminar(Integer id){
        domicilioDao.eliminar(id);
    }

}
