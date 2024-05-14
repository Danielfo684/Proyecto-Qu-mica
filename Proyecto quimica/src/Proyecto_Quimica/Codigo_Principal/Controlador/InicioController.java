package Proyecto_Quimica.Codigo_Principal.Controlador;

import Proyecto_Quimica.InterfazGrafica.Inicio;


public class InicioController {
    private Inicio ini;

    public InicioController(Inicio ini) {
        this.ini = ini;
    }

    // Para mostrar el login cuando se ejecuta el main
    public void MostrarLogin() {
        Inicio ini = new Inicio();
        ini.setVisible(true); //línea que permite que se muestre la ventana de JFrame
    }
}
