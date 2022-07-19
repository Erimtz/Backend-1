package dao.impl;

import dao.IDao;
import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MedicamentoDaoH2 implements IDao<Medicamento> {


    private static final Logger logger = Logger.getLogger(MedicamentoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/medicamentos";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";

    private static final String SQL_CREATE = "DROP TABLE IF EXISTS medicamentos; CREATE TABLE medicamentos (id INT PRIMARY KEY,  codigo INT,  nombre VARCHAR(100), laboratorio VARCHAR(100), cantidad INT, precio NUMERIC(15,2))";

    //SQL para modificar registros
    //private static final String SQL_UPDATE = "UPDATE cuentas SET saldo=? WHERE nro_cuenta=?";




    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            logger.info("conectado al driver");
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Statement statement = connection.createStatement();



            //statement.execute(SQL_CREATE); // como hacer para que se puedan ingresar nuevos registros sin borrar la tabla.???

            //2 Crear una sentencia
            logger.info("creando sentencias");
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO medicamentos VALUES(?,?,?,?,?,?);");
            preparedStatement.setInt(1,medicamento.getId());
            preparedStatement.setString(3, medicamento.getNombre());
            preparedStatement.setInt(2, medicamento.getCodigo());
            preparedStatement.setString(4, medicamento.getLaboratorio());
            preparedStatement.setInt(5, medicamento.getCantidad());
            preparedStatement.setDouble(6, medicamento.getPrecio());

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

            preparedStatement.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
            logger.error("no se conecto a sql ", throwables );
        }
        return medicamento;
    }


    @Override
    public Medicamento buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamento = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM medicamentos where id = ?");
            preparedStatement.setLong(1, id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {
                int idMedicamento = result.getInt(1);
                int codigoMedicamento =  result.getInt(2);
                String nombre = result.getString("nombre");
                String laboratorio = result.getString("laboratorio");
                int cantidadMedicamento =  result.getInt(5);
                double precio =  result.getDouble(6);

                medicamento = new Medicamento(idMedicamento,codigoMedicamento, nombre, laboratorio,cantidadMedicamento, precio);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return medicamento;
    }
}

