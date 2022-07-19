package test.service;

import dao.IDao;
import dao.impl.MedicamentoDaoH2;
import model.Medicamento;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MedicamentoServiceTest {
    private  static IDao<Medicamento> medicamentoDao = new MedicamentoDaoH2();

    @BeforeClass
    public static void cargarMedicamentos() {

        medicamentoDao.guardar(new Medicamento(140, 123, "Medicamento1", "mk", 2, 15.0));
        medicamentoDao.guardar(new Medicamento(1155, 123, "Medicamento2", "mk", 3, 15.0));
        medicamentoDao.guardar(new Medicamento(167, 123, "Medicamento3", "mk", 4, 15.0));
        medicamentoDao.guardar(new Medicamento(171, 123, "Medicamento4", "mk", 25, 15.0));
        int a = 4/0;
    }

    @Test
    public  void guardarYBuscarMedicamentosTest() {
        medicamentoDao.guardar(new Medicamento(135, 1234, "Pereyra","labo",1,10.0 ));
        Medicamento medicamento = medicamentoDao.buscar(1l);
        Assert.assertNotNull(medicamento);
        Assert.assertEquals(medicamento.getNombre(), "Medicamento1");


    }






}
