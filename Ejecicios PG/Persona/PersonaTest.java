import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {
        @Test
    public void mostrarNombre(){
        Persona persona1 = new Persona("facu", "Ramirez" );

        Assertions.assertAll(persona1.mostrarNombreConApellido());
        }
        @Test
    public void esMayorEdad(){
        Persona Mayor1 = new Persona(17 );
        Assertions.assertTrue(Mayor1.esMayorEdad());
    }
}