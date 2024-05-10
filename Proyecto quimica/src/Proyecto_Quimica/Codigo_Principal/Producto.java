/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Quimica.Codigo_Principal;

import java.util.Objects;

/**
 *
 * @author mdpan
 */
public class Producto {
   protected int idProducto;
   protected String nombre;
   protected int idLocalizacion;
   protected String ubicacionCodigo;
   protected int idUbicacion;
   protected int cantidad;
   protected int stockMinimo;

    public Producto(int idProducto, String nombre, int idLocalizacion, String ubicacionCodigo, int idUbicacion, int cantidad, int stockMinimo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idLocalizacion = idLocalizacion;
        this.ubicacionCodigo = ubicacionCodigo;
        this.idUbicacion = idUbicacion;
        this.cantidad = cantidad;
        this.stockMinimo = stockMinimo;
    }

    //CREAR UNA FUNCIÓN QUE 
    
    
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

    public String getUbicacionCodigo() {
        return ubicacionCodigo;
    }

    public void setUbicacionCodigo(String ubicacionCodigo) {
        this.ubicacionCodigo = ubicacionCodigo;
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
