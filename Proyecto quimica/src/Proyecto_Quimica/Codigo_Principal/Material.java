package Proyecto_Quimica.Codigo_Principal;

import java.sql.Date;

enum Subcategorias {
    PLASTICO, CRISTAL, INSTRUMENTALELECTRONICO
}

public class Material extends Producto {
    
    private int idMaterial;
    private Subcategorias subcategoria;
    private String descripcion;
    private String numeroSerie;
    private Date fechaCompra;
    

    public Material(int idMaterial, Subcategorias Subcategoria, String descripcion, String numeroSerie, Date fechaCompra, int idProducto, String nombre, int idLocalizacion, String ubicacionCodigo, int idUbicacion, int cantidad, int stockMinimo) {
        super(idProducto, nombre, idLocalizacion, ubicacionCodigo, idUbicacion, cantidad, stockMinimo);
  this.idMaterial = idMaterial;
  this.subcategoria = subcategoria;
  this.descripcion = descripcion;
  this.numeroSerie = numeroSerie;
  this.fechaCompra = fechaCompra;
    
    }
//CONSTRUCTOR SIN IDPROAUXLIAR YA QUE SE ASIGNA AUTOMATICAMENTE AL METERLO
    //EN LA BASE DE DATOS. ESTE CONSTRUCTOR NOS SIRVE PARA INSERTAR NUEVOS OBJETOS
        public Material( Subcategorias Subcategoria, String descripcion, String numeroSerie, Date fechaCompra, int idProducto, String nombre, int idLocalizacion, String ubicacionCodigo, int idUbicacion, int cantidad, int stockMinimo) {
        super(idProducto, nombre, idLocalizacion, ubicacionCodigo, idUbicacion, cantidad, stockMinimo);
  this.subcategoria = subcategoria;
  this.descripcion = descripcion;
  this.numeroSerie = numeroSerie;
  this.fechaCompra = fechaCompra;
    
    }
    
    
    public Material(String nombre) {
        super(nombre);
    }

}
