package Proyecto_Quimica.Modelos;

import java.sql.Date;

enum Subcategorias {
    PLASTICO, CRISTAL, INSTRUMENTALELECTRONICO
}

public class Material extends Almacen {
    
    private int idMaterial;
    private Subcategorias subcategoria;
    private String numeroSerie;
    private Date fechaCompra;
    

//    public Material(int idMaterial, Subcategorias subcategoria, String descripcion, String numeroSerie, Date fechaCompra, int idProducto, String nombre, int idLocalizacion, int idUbicacion, int cantidad, int stockMinimo) {
//        super(idProducto, nombre, idLocalizacion, idUbicacion, cantidad, stockMinimo, descripcion);
//        this.idMaterial = idMaterial;
//        this.subcategoria = subcategoria;
//        this.numeroSerie = numeroSerie;
//        this.fechaCompra = fechaCompra;
//    }
     public Material(int idMaterial, Subcategorias subcategoria, String numeroSerie, Date fechaCompra, String descripcion, int idProducto, String nombre, int idLocalizacion, int idUbicacion, int cantidad, int stockMinimo) {
        super(descripcion, idProducto, nombre, idLocalizacion, idUbicacion, cantidad, stockMinimo);
        this.idMaterial = idMaterial;
        this.subcategoria = subcategoria;
        this.numeroSerie = numeroSerie;
        this.fechaCompra = fechaCompra;
    }

    //CONSTRUCTOR SIN IDPROAUXLIAR YA QUE SE ASIGNA AUTOMATICAMENTE AL METERLO
    //EN LA BASE DE DATOS. ESTE CONSTRUCTOR NOS SIRVE PARA INSERTAR NUEVOS OBJETOS
    //Hacer un objeto de tipo material sin dar un id, para insertar
    public Material(Subcategorias subcategoria, String descripcion, String numeroSerie, Date fechaCompra, int idProducto, String nombre, String tipoProducto, int idUbicacion, int cantidad, int stockMinimo) {
        super(idProducto, nombre, descripcion);
        this.subcategoria = subcategoria;
        this.numeroSerie = numeroSerie;
        this.fechaCompra = fechaCompra;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public Subcategorias getSubcategoria() {
        return subcategoria;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setSubcategoria(Subcategorias subcategoria) {
        this.subcategoria = subcategoria;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
      
    
}
