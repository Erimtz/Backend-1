package com.company.dao;

import com.company.model.Odontologo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OdontologoDaoH2 implements IDao<Odontologo>{
    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/odontologos";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";


    private static final String DB_SQL_CREATE = "DROP TABLE IF EXISTS odontologos; CREATE TABLE odontologos (id INT auto_increment PRIMARY KEY,  numero_matricula INT,  nombre VARCHAR(100), apellido VARCHAR(100))";
    private static final String DB_SQL_SELECT_TODOS = "SELECT * FROM odontologos";
    private final static String DB_SQL_INSERT = "INSERT INTO odontologos (id, numero_matricula, nombre, apellido) VALUES (?,?,?,?)";


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando el odontólogos: " + odontologo);

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Conexión establecida");

            preparedStatement = connection.prepareStatement(DB_SQL_INSERT);
            preparedStatement.setInt(1, odontologo.getId());
            preparedStatement.setInt(2, odontologo.getNumeroMatricula());
            preparedStatement.setString(3, odontologo.getNombre());
            preparedStatement.setString(4, odontologo.getApellido());


            preparedStatement.execute();
            logger.info("Insertando un nuevo registro en la Tabla de odontólogos");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            logger.error("Error en relación a la base de datos", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("no se pudo cerrar la conexión" + e.getMessage());
                e.printStackTrace();
            }

            return odontologo;
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList();
        logger.info("Buscando los odontólogos");

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            logger.info("Conexión establecida");

            preparedStatement = connection.prepareStatement(DB_SQL_SELECT_TODOS);

            ResultSet resultado =  preparedStatement.executeQuery();
            logger.info("La sentencia SELECT ha sido ejecutada");

            while (resultado.next()){
                Integer idOdontologo = resultado.getInt("Id");
                Integer numeroMatriculaOdontologo = resultado.getInt("numero_matricula");
                String nombreOdontologo = resultado.getNString("nombre");
                String apellidoOdontologo = resultado.getNString("apellido");

                Odontologo odontologo = new Odontologo(idOdontologo, numeroMatriculaOdontologo, nombreOdontologo, apellidoOdontologo);
                logger.info("Obtenido el odontologo: " + odontologo);

                odontologos.add(odontologo);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            }
            catch (SQLException e){
                logger.error("no se pudo cerrar la conexión" + e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologos;
    }

    @Override
    public void crearBD() {
        Connection connection = null;

        try {
            //1 Levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            logger.info("conexion exitosa");

            //2 crear una BD con Statement
            Statement statement = connection.createStatement();
            statement.execute(DB_SQL_CREATE);
            logger.info("tabla creada");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

