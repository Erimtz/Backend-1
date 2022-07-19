import Service.MedicamentoService;
import dao.impl.MedicamentoDaoH2;
import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final Logger logger = Logger.getLogger(MedicamentoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/medicamentos";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";
    private static final String SQL_CREATE = "CREATE  TABLE IF NOT EXISTS medicamentos (id INT PRIMARY KEY,  codigo INT,  nombre VARCHAR(100), laboratorio VARCHAR(100), cantidad INT, precio NUMERIC(15,2))";



    public static void main(String[] args) {


        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Medicamento medicamento = new Medicamento(301,123,"vitamina","MK",15,10.000);

        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());

        //Esto deberia guardar en la tabla de la base de datos
        medicamentoService.guardar(medicamento);
        System.out.println(medicamentoService.buscar(7L));





        //statement.execute(SQL_CREATE); // como hacer para que se puedan ingresar nuevos registros sin borrar la tabla.???



    }
}