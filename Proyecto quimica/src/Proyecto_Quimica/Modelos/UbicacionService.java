/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class UbicacionService implements Editable<Ubicacion> {

    @Override
    public Ubicacion obtenerDato(int idUbicacion) {
        String sql = "SELECT * FROM Ubicacion WHERE idUbicacion = ?";

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setInt(1, idUbicacion);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ubicacion ubi = new Ubicacion(rs.getInt("idUbicacion"), rs.getString("nombre"), rs.getInt("idLocalizacion"));
                return ubi;
            }

            return null;

        } catch (SQLException e) {
            System.err.println("Error al obtener las ubicaciones de la base de datos!" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ubicacion> obtenerDatos() {
        String sql = "SELECT * FROM Ubicacion";

        List<Ubicacion> listaUbicaciones = new ArrayList<>();

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Ubicacion ubi = new Ubicacion(rs.getInt("idUbicacion"), rs.getString("nombre"), rs.getInt("idLocalizacion"));
                listaUbicaciones.add((Ubicacion) ubi);
            }
            return listaUbicaciones;
        } catch (SQLException e) {
            System.err.println("Error al obtener las ubicaciones de la base de datos!" + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void añadir(Ubicacion elemento) {
        //ESTO ES UN INSERT INTO
    }

    @Override
    public void editar(Ubicacion elemento) {
        String sql = "UPDATE Ubicacion SET nombre=? WHERE idUbicacion=?";

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setString(1, elemento.getNombre());
            statement.setInt(2, elemento.getIdLocalizacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar la ubicacion!" + e.getMessage());
        }
    }

    @Override
    public void eliminar(int idElemento) {
        String sql = "DELETE FROM Ubicacion WHERE idUbicacion=?";

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setInt(1, idElemento);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar la ubicacion!" + e.getMessage());
        }
    }

}
