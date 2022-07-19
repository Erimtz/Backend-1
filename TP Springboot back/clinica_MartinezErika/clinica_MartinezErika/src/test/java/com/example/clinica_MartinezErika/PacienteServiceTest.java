package com.example.clinica_MartinezErika;


import com.example.clinica_MartinezErika.dao.impl.DomicilioDaoH2;
import com.example.clinica_MartinezErika.dao.impl.PacienteDaoH2;
import com.example.clinica_MartinezErika.model.Domicilio;
import com.example.clinica_MartinezErika.model.Paciente;
import com.example.clinica_MartinezErika.service.DomicilioService;
import com.example.clinica_MartinezErika.service.PacienteService;
import org.junit.Assert;
import org.junit.Test;



public class PacienteServiceTest {
    private static final PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());


    /*@BeforeClass
    public static void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente(5L, "Santiago", "Paz", "Santiago@dh.com", domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente(7L, "Micaela", "Perez", "mica@dh.com", domicilio));
    }*/

    @Test
    public void agregarYBuscarPacienteTest(){
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente(1, "Tomas", "Pereyra", "pereyra@dh.com", domicilio));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }


    /*@Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(3);
        Assert.assertTrue(pacienteService.buscar(3L) == null);

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }*/
}
