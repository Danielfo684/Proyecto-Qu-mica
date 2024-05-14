/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Quimica.Codigo_Principal.Controlador;

import Proyecto_Quimica.BBDD.Conexion;
import Proyecto_Quimica.Modelos.Ubicacion;
import Proyecto_Quimica.Modelos.UbicacionService;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UbicacionController {
    
    UbicacionService ubicacionModel;
    
    public UbicacionController() {
        
    }
    
    public UbicacionService getUbicacionModel() {
        return ubicacionModel;
    }
    
    public void setUbicacionModel (UbicacionService productoModel){
        this.ubicacionModel = productoModel;
    }
    
    public List<Ubicacion> getUbicaciones() {
        //Obtener Ubicaciones
        
        UbicacionService productoModel = new UbicacionService();
        this.setUbicacionModel(ubicacionModel);
        List<Ubicacion> listaProductos = productoModel.obtenerDatos();
        
        return listaProductos;
    }
    
    public void actualizarUbicacion(int idProducto, String nuevoNombre) {
        //Obtener Ubicaciones
        Conexion conexionBD = new Conexion();
        conexionBD.getConexion();
        
        UbicacionService productoModel = new UbicacionService();
        
        Ubicacion ubi = productoModel.obtenerDato(idProducto);
        
        ubi.setNombre(nuevoNombre);
        productoModel.editar(ubi);
    }
    
    public void eliminarUbicacion(int idProducto) {
        ubicacionModel = this.getUbicacionModel();
        ubicacionModel.eliminar(idProducto);
    }
}
