package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ColeccionPersonas {

    //Metodo para filtras las personas que se pueden agregar
    public List<Persona> filtrar(List<Persona> listaPersonas){
        //Opción 1: Antes de Java 8
        List<Persona> listaFiltrada= new ArrayList<>();
        for (Persona persona : listaPersonas){
            if (persona.esMayorDeEdad() && persona.getNombre().length() >= 5){
                listaFiltrada.add(persona);
            }
        }
        return listaFiltrada;


        //Opción 2: Usando stream de Java8
        /*return listaPersonas.stream()
                .filter(p -> p.esMayorDeEdad() && p.getNombre().length() >= 5)
                .collect(Collectors.toList());*/
    }

}
