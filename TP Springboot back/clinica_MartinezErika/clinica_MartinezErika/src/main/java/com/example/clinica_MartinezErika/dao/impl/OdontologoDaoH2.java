package com.example.clinica_MartinezErika.dao.impl;


import com.example.clinica_MartinezErika.dao.configuracion.ConfiguracionJDBC;
import com.example.clinica_MartinezErika.model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDaoH2 implements IDao<Odontologo> {


    private final ConfiguracionJDBC configuracionJDBC ;
    private static final Logger logger = LogManager.getLogger(String.valueOf(OdontologoDaoH2.class));

    public OdontologoDaoH2(ConfiguracionJDBC configuracionJDBC) {
        this.configuracionJDBC = configuracionJDBC;
    }


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando el odontólogos: " + odontologo);

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            logger.info("Conexión establecida");

            preparedStatement.setInt(1, odontologo.getId());
            preparedStatement.setInt(2, odontologo.getNumeroMatricula());
            preparedStatement.setString(3, odontologo.getNombre());
            preparedStatement.setString(4, odontologo.getApellido());


            preparedStatement.execute();
            logger.info("Insertando un nuevo registro en la Tabla de odontólogos");

        } catch (SQLException e) {
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
    public Odontologo buscar(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList();
        logger.info("Buscando los odontólogos");

        try {

            logger.info("Conexión establecida");


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

        } catch (SQLException e) {
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
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }

}

