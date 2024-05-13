package Proyecto_Quimica.Modelos;

import Proyecto_Quimica.BBDD.Conexion;
import Proyecto_Quimica.Excepciones.CampoVacioExcepcion;
import Proyecto_Quimica.Interface.Editable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Localizacion extends Object{
    
    private int idLocalizacion;
    private String nombreAlmacen;

    public Localizacion(int idLocalizacion, String nombreAlmacen) {
        this.idLocalizacion = idLocalizacion;
        this.nombreAlmacen = nombreAlmacen;
    }
    
    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }
    
}
