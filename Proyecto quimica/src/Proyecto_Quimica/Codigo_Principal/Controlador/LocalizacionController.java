package Proyecto_Quimica.Codigo_Principal.Controlador;

import Proyecto_Quimica.BBDD.Conexion;
import Proyecto_Quimica.Excepciones.CampoVacioExcepcion;
import Proyecto_Quimica.Modelos.Localizacion;
import Proyecto_Quimica.Modelos.LocalizacionService;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LocalizacionController {

    LocalizacionService localizacionModel;
    
    public LocalizacionController() {
        
    }

    public LocalizacionService getLocalizacionModel() {
        return localizacionModel;
    }

    public void setLocalizacionModel(LocalizacionService localizacionModel) {
        this.localizacionModel = localizacionModel;
    }
    

    public List<Localizacion> getSalas() {
        // Obtener localizaciones
        LocalizacionService localizacionModel = new LocalizacionService(); 
        this.setLocalizacionModel(localizacionModel);
        List<Localizacion> listaSalas = localizacionModel.obtenerDatos();
        
        return listaSalas;

    }
    
    public void actualizarUsuario(int idLocalizacion, String nuevoNombre) {
        // Obtener localizaciones
        LocalizacionService localizacionModel = new LocalizacionService(); 
        
        Localizacion sala = localizacionModel.obtenerDato(idLocalizacion);

        sala.setNombreAlmacen(nuevoNombre);
        localizacionModel.editar(sala);
    }
    
    public void eliminarUsuario(int idLocalizacion) {
        localizacionModel = this.getLocalizacionModel();
        localizacionModel.eliminar(idLocalizacion);
    }
}



