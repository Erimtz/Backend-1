package com.company;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColeccionPersonasTest {

    @Test
    public void probarFiltro(){
        //Se crean instancias de Persona
        Persona persona1= new Persona("Juan", 11);
        Persona persona2= new Persona("Pedro", 23);
        Persona persona3= new Persona("Ana", 42);
        Persona persona4= new Persona("Luz", 37);
        Persona persona5= new Persona("Julián", 68);

        //Personas a agregar
        List<Persona> lista= Arrays.asList(persona1, persona2, persona3, persona4, persona5);

        //CUANDO
        ColeccionPersonas coleccion= new ColeccionPersonas();
        List<Persona> resultado= coleccion.filtrar(lista);
        Assertions.assertTrue(resultado.size() == 2);

    }
}
