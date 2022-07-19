package Service;

import dao.IDao;
import model.Medicamento;

public class MedicamentoService {


    //atributo
    private IDao<Medicamento> medicamentodao;

    //constructor
    public MedicamentoService(IDao<Medicamento> medicamentodao) {
        this.medicamentodao = medicamentodao;
    }


    // operaciones

    public  Medicamento guardar (Medicamento medicamento){
        return medicamentodao.guardar(medicamento);
    }

    public  Medicamento buscar (Long id){
        return  medicamentodao.buscar(id);
    }

}
