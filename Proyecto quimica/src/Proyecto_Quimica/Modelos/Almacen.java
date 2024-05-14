package Proyecto_Quimica.Modelos;

public class Almacen extends Producto {
    private String descripcion;

    public Almacen(int idProducto, String nombre, int idLocalizacion, int idUbicacion, int cantidad, int stockMinimo, String descripcion) {
        super(idProducto, nombre, idLocalizacion, idUbicacion, cantidad, stockMinimo);
        this.descripcion = descripcion;
    }

    public Almacen(String nombre, String descripcion) {
        super(nombre);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


