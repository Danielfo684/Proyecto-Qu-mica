/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Quimica.Modelos;

import java.util.Objects;

enum tipoProducto {REACTIVO, MATERIAL, PRODUCTOAUXILIAR};

public class Producto {
   protected int idProducto;
   protected String nombre;
   protected int idLocalizacion;
   protected int idUbicacion;
   protected int cantidad;
   protected int stockMinimo;
   protected String nombreUbicacion;
   protected String nombreLocalizacion;
   protected  tipoProducto tipo;

   
   //CONSTRUCTOR PARA INSERTAR NUEVOS PRODUCTOS
    public Producto(int idProducto, String nombre, int idLocalizacion, int idUbicacion,
            int cantidad, int stockMinimo, tipoProducto tipo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idLocalizacion = idLocalizacion;
        this.idUbicacion = idUbicacion;
        this.cantidad = cantidad;
        this.stockMinimo = stockMinimo;
        this.tipo = tipo;
    }
    
    //CONSTRUCTOR PARA CONSULTAS SELECT DE PRODUCTOS
    public Producto(String nombre, int cantidad, String tipo, String nombreUbicacion, String nombreLocalizacion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.nombreUbicacion = nombreUbicacion;
        this.nombreLocalizacion = nombreLocalizacion;
        this.tipo = tipoProducto.valueOf(tipo);
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }

    public String getNombreLocalizacion() {
        return nombreLocalizacion;
    }

    public void setNombreLocalizacion(String nombreLocalizacion) {
        this.nombreLocalizacion = nombreLocalizacion;
    }

    public tipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(tipoProducto tipo) {
        this.tipo = tipo;
    }


    
    
    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
   
   
}
