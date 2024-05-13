/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Quimica.BBDD;

import Proyecto_Quimica.Modelos.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdpan
 */
public class SentenciasSQL {

    //   Dos variables encargadas de enviar las sentencias y recibir el resultado de las mismas.
    static PreparedStatement sentenciaSql = null;
    static ResultSet resultadoConsulta = null;
    private static Connection conexion = null;


    public static ArrayList<Producto> busquedaBasica(String seleccion) {
 try {
            String consulta = "Select p.nombre, p.cantidad, p.tipoProducto, u.nombre, "
                    + "l.nombreAlmacen "
                    + "FROM productos p INNER JOIN ubicacion u ON u.idUbicacion = p.idUbicacion"
                    + "INNER JOIN localizacion l ON l.idLocalizacion = u.idLocalizacion "
                    + "WHERE p.nombre LIKE '%" + seleccion + "%'";
            sentenciaSql.setString(1, consulta);
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
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, "Problema detectado en el envío de SELECT a mySQL", ex);
        }
        return null;    }

}
