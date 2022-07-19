package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {

    //METODO de TEST

    @Test
    public void probarMayorEdad(){
        //Se crean las personas a probar
        Persona persona1= new Persona("Facu", 11);
        Persona persona2= new Persona("Roque", 42);

        //CUANDO / ENTONCES
        Assertions.assertTrue(persona2.esMayorDeEdad());
        //Assert.assertEquals(true,persona2.esMayorDeEdad());
        Assertions.assertFalse(persona1.esMayorDeEdad());
        //Assert.assertEquals(false,persona1.esMayorDeEdad());
    }




}