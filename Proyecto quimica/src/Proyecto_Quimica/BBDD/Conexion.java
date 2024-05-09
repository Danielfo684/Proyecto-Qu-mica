package Proyecto_Quimica.BBDD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdpan
 */
public class Conexion {

    Connection conexion;
    Statement consultas;

    public Conexion() {
    }

    public static Connection conectarRoot() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/quimica", "root", "");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }

    public Connection conectarAlumno() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/quimica", "alumno", "alumno");
            System.out.println("Conexion correcta con la base de datos");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Hubo un problema con la conexión a la base de datos");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public Connection conectarProfesor(String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/quimica", user, password);
            System.out.println("Conexion correcta con la base de datos");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Hubo un problema con la conexión a la base de datos");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public static void vaciarBD() throws SQLException {
        try (Connection conexion = Conexion.conectarRoot()) {
            //creamos una sentencia que nos elimine las claves foráneas
            PreparedStatement sentenciaSQL = conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            sentenciaSQL.execute();

            String[] tablasBD = {"formato", "Localizacion", "Ubicacion",
                "Productos", "Reactivo", "Material", "ProductoAuxiliar",
                "Riesgo", "ReactivoRiesgo"};
        }
    }

    public void desconectar() {
        try {
            conexion.close();
            System.out.println("Conexión con base de datos terminada");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
