package Proyecto_Quimica.BBDD;

// Imports para leer el fichero de configuracion con credenciales para conectar la base de datos */
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;


public class Conexion {

    // Connection conexion;
    // Statement consultas;
    public static final String FILE_CONF="ficheros/quimicos.config";
    private static Connection conexion;
    private Properties properties;
    private String driver;
    private String url;
    private String usuario;
    private String contraseña;
    private String usuarioAlumno;
    private String contraseñaAlumno;
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    
    public String getUsuarioAlumno(){
        return usuarioAlumno;
    }
    
    public String getContraseñaAlumno(){
        return contraseñaAlumno;
    }
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection nuevaConexion) {
        conexion = nuevaConexion;
    }
    
    public void getConfiguracion() {
        properties = new Properties();
        try {
            FileReader reader = new FileReader(FILE_CONF);
            properties.load(reader);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            usuario = properties.getProperty("user");
            contraseña = properties.getProperty("password");
            usuarioAlumno = properties.getProperty("user");
            contraseñaAlumno = properties.getProperty("password");
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }

    public Connection conectarRoot(String usuario, String contraseña) throws SQLException {
        
        Connection conn = null;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
            return null; // Retorna null si hay un error al cargar el controlador
        }
        
        conn = DriverManager.getConnection(url, usuario, contraseña);  
        this.setConexion(conn);
        
        return conn;
    }

    
    public Connection conectarAlumno() {
        try {
            return conectarRoot(usuarioAlumno, contraseñaAlumno);
        } catch (SQLException ex) {
            System.out.println("Hubo un problema con la conexión a la base de datos");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Connection conectarProfesor() {
        try {
            return conectarRoot(usuario, contraseña);
        } catch (SQLException ex) {
            System.out.println("Hubo un problema con la conexión a la base de datos");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
