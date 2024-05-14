/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Quimica.Modelos;

import java.sql.Date;

/**
 *
 * @author mdpan
 */
public class Reactivo extends Almacen {

    private int idReactivo;
    private String gradoPureza;
    private Date fechaCaducidad;

    public Reactivo(int idReactivo, String descripcion, String gradoPureza, Date fechaCaducidad, int idProducto, String nombre, int idLocalizacion, int idUbicacion, int cantidad, int stockMinimo) {
        super(idProducto, nombre, idLocalizacion, idUbicacion, cantidad, stockMinimo, descripcion);
        this.idReactivo = idReactivo;
        this.gradoPureza = gradoPureza;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    //CONSTRUCTOR SIN IDREACTIVO YA QUE SE ASIGNA AUTOMATICAMENTE AL METERLO
    //EN LA BASE DE DATOS. ESTE CONSTRUCTOR NOS SIRVE PARA INSERTAR NUEVOS OBJETOS
    public Reactivo(String descripcion, String gradoPureza, Date fechaCaducidad, int idProducto, String nombre, int idLocalizacion, int idUbicacion, int cantidad, int stockMinimo) {
        super(nombre, descripcion);
        this.gradoPureza = gradoPureza;
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getIdReactivo() {
        return idReactivo;
    }

    public void setIdReactivo(int idReactivo) {
        this.idReactivo = idReactivo;
    }

    public String getGradoPureza() {
        return gradoPureza;
    }

    public void setGradoPureza(String gradoPureza) {
        this.gradoPureza = gradoPureza;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

}
