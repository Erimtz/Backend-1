package test.com.company;

import com.company.dao.OdontologoDaoH2;
import com.company.model.Odontologo;
import com.company.service.OdontologoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OdontologoServiceTest {
    private OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());

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
