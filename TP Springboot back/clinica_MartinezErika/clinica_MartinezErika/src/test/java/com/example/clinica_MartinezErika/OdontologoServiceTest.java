package com.example.clinica_MartinezErika;


import com.example.clinica_MartinezErika.dao.configuracion.ConfiguracionJDBC;
import com.example.clinica_MartinezErika.dao.impl.OdontologoDaoH2;
import com.example.clinica_MartinezErika.model.Odontologo;
import com.example.clinica_MartinezErika.service.OdontologoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


public class OdontologoServiceTest {
    private ConfiguracionJDBC configuracionJDBC;
    private OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2(configuracionJDBC));

    @Before
    public void init(){
        //Reinicia la base de datos para cada metodo.
        odontologoService.crearTabla();
    }

    @Test
    public void insertarOdontologoTest() {
        //creo estudiante
        Odontologo odontologo1 = new Odontologo(2, 1213, "Juan", "Casas");
        //lo guardo
        Odontologo odontologoGuardado = odontologoService.guardarOdontologo(odontologo1);
        //revisa si existe
        Assert.assertNotNull(odontologoGuardado);
    }


    @Test
    public void buscarTodosTest(){
        Odontologo odontologo3 = new Odontologo(3,5678,"Jaime","Martinez");
        Odontologo odontologo4 = new Odontologo(4,8910,"María","Rodríguez");

        odontologoService.guardarOdontologo(odontologo3);
        odontologoService.guardarOdontologo(odontologo4);

        List<Odontologo> lista = odontologoService.buscarTodos();

        System.out.println(odontologoService.buscarTodos().size());

        Assert.assertEquals(2, odontologoService.buscarTodos().size());
    }
}
