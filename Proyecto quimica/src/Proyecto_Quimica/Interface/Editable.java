package Proyecto_Quimica.Interface;

import java.util.List;

public interface Editable<T> {
    T obtenerDato(int id);
    List<T> obtenerDatos();
    void añadir(T elemento); 
    void editar(T elemento);
    void eliminar(int id);
}