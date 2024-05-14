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


public class ProductoService implements Editable<Producto> {

    @Override
    public Producto obtenerDato(int idProducto) {
        String sql = "SELECT * FROM Productos WHERE idProducto = ?";

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setInt(1, idProducto);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("idProducto"), rs.getString("nombre"));
                return producto;
            }

            return null;

        } catch (SQLException e) {
            System.err.println("Error al obtener los productos de la base de datos!" + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Producto> obtenerDatos() {
        String sql = "SELECT prod.idProducto, prod.nombre, ubi.idUbicacion, ubi.nombre, prod.cantidad, prod.stockMinimo, prod.tipoProducto "
           + "FROM quimicas.productos AS prod, quimicas.ubicacion AS ubi "
           + "WHERE prod.idUbicacion = ubi.idUbicacion";

        List<Producto> listaProductos = new ArrayList<>();

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("prod.idProducto"), rs.getString("prod.nombre"), rs.getString("prod.tipoProducto"),
                        rs.getInt("ubi.idUbicacion"), rs.getInt("prod.cantidad"), rs.getInt("prod.stockMinimo"), rs.getString("ubi.nombre"));
                listaProductos.add((Producto) producto);
            }
            return listaProductos;
        } catch (SQLException e) {
            System.err.println("Error al obtener los productos de la base de datos!" + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void añadir(Producto elemento) {
        //ESTO ES UN INSERT INTO
    }

    @Override
    public void editar(Producto elemento) {
        String sql = "UPDATE Productos SET nombre=? WHERE idUbicacion=?, cantidad=?, stockMinimo=? WHERE idProducto=?";

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setString(1, elemento.getNombre());
            statement.setInt(2, elemento.getIdUbicacion());
            statement.setInt(3, elemento.getCantidad());
            statement.setInt(4, elemento.getStockMinimo());
            statement.setInt(5, elemento.getIdProducto());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el producto!" + e.getMessage());
        }
    }

    @Override
    public void eliminar(int idElemento) {
        String sql = "DELETE FROM Productos WHERE idProducto=?";

        try (PreparedStatement statement = Conexion.getConexion().prepareStatement(sql)) {
            statement.setInt(1, idElemento);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar el producto!" + e.getMessage());
        }
    }

}
