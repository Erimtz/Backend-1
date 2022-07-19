package com.example.clinica_MartinezErika.service;


import com.example.clinica_MartinezErika.dao.impl.PacienteDaoH2;
import com.example.clinica_MartinezErika.model.Domicilio;
import com.example.clinica_MartinezErika.model.Paciente;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PacienteService {

    List<Paciente> listPacientes= new ArrayList<>();

    //Constructor
    public PacienteService(PacienteDaoH2 pacienteDaoH2) {
        listPacientes= Arrays.asList(new Paciente("Juan","Paez","Paez.2@dh.com", new Domicilio("hidalgo", "seis", "norte", "centro")));
                new Paciente("Jose","Garcia","Garcia123@dh.com",new Domicilio ("laurel", "dos", "sur", "nuevo estado"));
    }


    public List<Paciente> getPacientes(){
        return listPacientes;
    }

    public Paciente buscarPorEmail(String email){
        Paciente pacienteRetorno= null;
        for (Paciente pacienteAux : listPacientes){
            if (pacienteAux.getEmail().equals(email)){
                pacienteRetorno= pacienteAux;
            }
        }
        return pacienteRetorno;
    }

    public Paciente guardar(Paciente paciente) {
        return paciente;
    }

    public Object buscar(Integer id) {
        return null;
    }

    public void eliminar(int id) {
    }

    public List<Paciente> buscarTodos() {
        return null;
    }

    public Paciente actualizar(Paciente paciente) {
        return paciente;
    }
}
