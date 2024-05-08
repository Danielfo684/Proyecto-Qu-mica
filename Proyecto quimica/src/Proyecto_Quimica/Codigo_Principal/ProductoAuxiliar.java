/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Quimica.Codigo_Principal;

/**
 *
 * @author mdpan
 */
public class ProductoAuxiliar extends Producto {
    private int idProductoAuxiliar;
    private String formato;
    
    
    public ProductoAuxiliar(String nombre) {
        super(nombre);
    }
        public ProductoAuxiliar(int idProductoAuxiliar, String formato, int idProducto, String nombre, int idLocalizacion, String ubicacionCodigo, int idUbicacion, int cantidad, int stockMinimo) {
        super(idProducto, nombre, idLocalizacion, ubicacionCodigo, idUbicacion, cantidad, stockMinimo);
    this.idProductoAuxiliar = idProductoAuxiliar;
    this.formato = formato;
        }

    
}
