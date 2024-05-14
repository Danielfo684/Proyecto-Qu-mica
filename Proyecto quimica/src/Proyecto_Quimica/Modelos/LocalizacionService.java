package Proyecto_Quimica.Modelos;

import Proyecto_Quimica.BBDD.Conexion;
import Proyecto_Quimica.Excepciones.CampoVacioExcepcion;
import Proyecto_Quimica.Interface.Editable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LocalizacionService implements Editable<Localizacion>{
    
    private Conexion conexionBD;

    public LocalizacionService() {
    }
    
    @Override
    public Localizacion obtenerDato(int idLocalizacion){
        String sql = "SELECT * FROM Localizacion WHERE idLocalizacion = ?";

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setInt(1, idLocalizacion);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Localizacion sala = new Localizacion(rs.getInt("idLocalizacion"),rs.getString("nombreAlmacen"));
                return sala;
            }
            
            return null;
            
        } catch (SQLException e) {
            System.err.println("Error al obtener las localizaciones de la base de datos!" + e.getMessage());
            e.printStackTrace();
            return null;
        }
        
    }
     
    @Override
    public List<Localizacion> obtenerDatos() {
        String sql = "SELECT * FROM Localizacion";
        List<Localizacion> listaSalas = new ArrayList<>();
    
        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Localizacion sala = new Localizacion(rs.getInt("idLocalizacion"), rs.getString("nombreAlmacen"));            
                listaSalas.add((Localizacion) sala); 
            }
            return listaSalas;
        } catch (SQLException e) {
            System.err.println("Error al obtener las localizaciones de la base de datos!" + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void añadir(Localizacion elemento) {
        // ESTO ES UN INSERT INTO
    }
    
    @Override
    public void editar(Localizacion elemento) {
        String sql = "UPDATE Localizacion SET nombreAlmacen=? WHERE idLocalizacion=?";
        
        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setString(1, elemento.getNombreAlmacen());
            statement.setInt(2, elemento.getIdLocalizacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar la localizacion!" + e.getMessage());
        }
    }

    @Override
    public void eliminar(int idElemento) {
        String sql = "DELETE FROM Localizacion WHERE idLocalizacion=?";
        
        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setInt(1, idElemento);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar la localización!" + e.getMessage());
        }
    }
    
}
