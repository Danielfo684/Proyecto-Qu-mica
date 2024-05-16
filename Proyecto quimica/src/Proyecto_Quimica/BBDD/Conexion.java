package Proyecto_Quimica.BBDD;

// Imports para leer el fichero de configuracion con credenciales para conectar la base de datos */
import Proyecto_Quimica.Modelos.Producto;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.ArrayList;

public  class Conexion{

    // Connection conexion;
    // Statement consultas;
    public static final String FILE_CONF = "ficheros/quimicos.config";
    private static Connection conexion;
    public static Conexion instance;
    private Properties properties;
    private static String driver;
    private static String url;
    private String usuario;
    private String contraseña;
    private static String usuarioAlumno;
    private static String contraseñaAlumno;

    private  static PreparedStatement sentenciaSql = null;
    private  static ResultSet resultadoConsulta = null;

    public static Conexion obtenerConexion() {
        if(instance == null) {
            instance = new Conexion();
            return instance;
        }
        return instance;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUsuarioAlumno() {
        return usuarioAlumno;
    }

    public String getContraseñaAlumno() {
        return contraseñaAlumno;
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection nuevaConexion) {
        conexion = nuevaConexion;
    }

    public static ArrayList<Producto> busquedaBasica(String seleccion) {
        try {
           conectarAlumno();
            String consulta = "Select p.nombre, p.cantidad, p.tipoProducto, u.nombre, "
                    + "l.nombreAlmacen "
                    + "FROM productos p INNER JOIN ubicacion u ON u.idUbicacion = p.idUbicacion "
                    + "INNER JOIN localizacion l ON l.idLocalizacion = u.idLocalizacion "
                    + "WHERE p.nombre LIKE '%" + seleccion + "%'";

            sentenciaSql = conexion.prepareStatement(consulta);
            resultadoConsulta = sentenciaSql.executeQuery(consulta);
            resultadoConsulta.next();
            ArrayList<Producto> listado = new ArrayList<>();
            while (resultadoConsulta.next()) {  //aquí vamos cogiendo de cada columna del SELECT un string y se lo asignamos a un nuevo producto que creamos
                Producto producto = new Producto(resultadoConsulta.getString(1),
                        resultadoConsulta.getInt(2), resultadoConsulta.getString(3),
                        resultadoConsulta.getString(4), resultadoConsulta.getString(5));
                listado.add(producto);
            }
            return listado;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
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

    public static Connection conectarRoot(String usuario, String contraseña) throws SQLException {

        Connection conn = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
            return null; // Retorna null si hay un error al cargar el controlador
        }

        conn = DriverManager.getConnection(url, usuario, contraseña);
        setConexion(conn);

        return conn;
    }

    public static Connection conectarAlumno() {
        try {
            return conectarRoot(usuarioAlumno, contraseñaAlumno);
        } catch (SQLException ex) {
            System.out.println("Hubo un problema con la conexión a la base de datos.");
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
