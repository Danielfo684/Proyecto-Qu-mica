package Proyecto_Quimica.Codigo_Principal;

import Proyecto_Quimica.Codigo_Principal.Controlador.InicioController;
import Proyecto_Quimica.InterfazGrafica.Inicio;


public class Main {
    public static void main(String[] args) {
        Inicio ini = new Inicio();
        
        // Creación del controlador para la ventana principal (parte del MVC)
        InicioController inicioController = new InicioController(ini);
        
        inicioController.MostrarLogin();

    }  
}
