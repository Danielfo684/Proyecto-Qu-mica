
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
    
    
    public Connection conectarAlumno(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/quimica", "alumno", "alumno");
            System.out.println("Conexion correcta con la base de datos");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Hubo un problema con la conexión a la base de datos");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
     public Connection conectarProfesor(String user, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/quimica", user, password);
            System.out.println("Conexion correcta con la base de datos");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Hubo un problema con la conexión a la base de datos");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    public void desconectar(){
        try {
            conexion.close();
            System.out.println("Conexión con base de datos terminada");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
