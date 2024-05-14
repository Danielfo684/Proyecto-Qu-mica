/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Quimica.Codigo_Principal.Controlador;

import Proyecto_Quimica.BBDD.Conexion;
import Proyecto_Quimica.Modelos.Producto;
import Proyecto_Quimica.Modelos.ProductoService;
import java.util.List;

public class ProductoController {
    
    ProductoService productoModel;
    
    public ProductoController() {
        
    }
    
    public ProductoService getProductoModel() {
        return productoModel;
    }
    
    public void setProductoModel (ProductoService productoModel) {
        this.productoModel = productoModel;
    }
    
    public List<Producto> getProductos() {
        //Obterner Productos
        
        ProductoService productoModel = new ProductoService();
        this.setProductoModel(productoModel);
        List<Producto> listaProductos = productoModel.obtenerDatos();
        
        return listaProductos;
    }
    
    public void actualizarProducto(int idProducto, String nuevoNombre, int nuevaUbicacion, int nuevaCantidad, int nuevoMinStock) {
        //Obetener Productos
        
        Conexion conexionBD = new Conexion();
        conexionBD.getConexion();
        
        Producto prod = productoModel.obtenerDato(idProducto);
        
        prod.setNombre(nuevoNombre);
        prod.setIdUbicacion(nuevaUbicacion);
        prod.setCantidad(nuevaCantidad);
        prod.setStockMinimo(nuevoMinStock);
        productoModel.editar(prod);
    }
    
    public void eliminarProducto(int idProducto){
        productoModel = this.getProductoModel();
        productoModel.eliminar(idProducto);
    }
}
