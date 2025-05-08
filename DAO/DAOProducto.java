//paquete entidad dao
package DAO;

import Entidades.Producto;
import Util.ConexionBD;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Azter Baez
 */
public class DAOProducto {

    public void crearProducto(Producto producto) throws SQLException {
        String sql = """
                 INSERT INTO Producto (
                          Nombre_Prod ,
                           Tipo_Prod,
                           Existencia_Prod ,
                           Precio_Prod ,
                           Fe_caducidad )     
                       VALUES (?, ?, ?, ?, ?)""";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre_produ());
            stmt.setString(2, producto.getTipo_produ());
            stmt.setInt(3, producto.getExistencia_Prod());
            stmt.setFloat(4, producto.getPrecio_produ());
            stmt.setDate(5, new java.sql.Date(producto.getFe_caducidad().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Producto> leerTodosProductos() throws SQLException {
        String sql = "SELECT * FROM Producto";
        List<Producto> productos = new ArrayList<>();
        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre_produ(rs.getString("Nombre_Prod"));
                producto.setTipo_produ(rs.getString("Tipo_Prod"));
                producto.setExistencia_Prod(rs.getInt("Existencia_Prod"));
                producto.setPrecio_produ(rs.getFloat("Precio_Prod"));
                producto.setFe_caducidad(rs.getDate("Fe_caducidad"));
                productos.add(producto);
            }
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE Producto SET Nombre_Prod = ?, Tipo_Prod = ?, Existencia_Prod = ?, Precio_Prod = ?, Fe_caducidad = ? WHERE id_producto = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre_produ());
            stmt.setString(2, producto.getTipo_produ());
            stmt.setInt(3, producto.getExistencia_Prod());
            stmt.setFloat(4, producto.getPrecio_produ());
            stmt.setDate(5,  new java.sql.Date(producto.getFe_caducidad().getTime()));
            stmt.setInt(6, producto.getId_producto());
            stmt.executeUpdate();
        }
    }

    public void eliminarProducto(int id_producto) throws SQLException {
        String sql = "DELETE FROM Producto WHERE id_producto = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id_producto);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOProducto dao = new DAOProducto();
            // Actualizar un producto
            Producto producto = new Producto();
            producto.setId_producto(1); // ID existente
            producto.setNombre_produ("Collar Negro Actualizada");
            producto.setTipo_produ("Accesorios");
            producto.setExistencia_Prod(23);
            producto.setPrecio_produ(52);
            producto.setFe_caducidad(new java.util.Date());
            dao.actualizarProducto(producto);
            System.out.println("Producto actualizado.");

            // ID a eliminar  
            //  Eliminar un producto
            dao.eliminarProducto(2);
            System.out.println("Producto eliminado.");

            List<Producto> productos = dao.leerTodosProductos();
            System.out.println("Lista de productos:");
            for (Producto prod : productos) {
                System.out.println("id_producto: " + prod.getId_producto()
                        + ", Nombre_Prod: " + prod.getNombre_produ()
                        + ", Tipo_Prod: " + prod.getTipo_produ()
                        + ", Existencia_Prod: " + prod.getExistencia_Prod()
                        + ", Precio_Prod: " + prod.getPrecio_produ()
                        + ", Fe_caducidad: " + prod.getFe_caducidad());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
