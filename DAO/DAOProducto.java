package DAO;

import Entidades.Producto;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author welvi
 */
public class DAOProducto {

    public void crearProducto(Producto producto) throws SQLException {
        String sql = """
                INSERT INTO Producto (
                     Nombre_Prod,
                     Tipo_Prod,
                     Existencia_Prod,
                     Precio_Costo, 
                     Precio_Venta,
                     Fe_caducidad)
                VALUES (?, ?, ?, ?, ?, ?)""";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre_prod());
            stmt.setString(2, producto.getTipo_produ());
            stmt.setDouble(3, producto.getExistencia_Prod());
            stmt.setDouble(4, producto.getPrecio_Costo());
            stmt.setDouble(5, producto.getPrecio_Venta());
            stmt.setDate(6, new java.sql.Date(producto.getFecha_caducidad().getTime()));

            stmt.executeUpdate();
        }
    }

    public List<Producto> leerTodosProductos() throws SQLException {
        String sql = "SELECT * FROM Producto";
        List<Producto> producto = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                producto.add(new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("Nombre_Prod"),
                        rs.getString("Tipo_Prod"),
                        rs.getDouble("Existencia_Prod"),
                        rs.getDouble("Precio_Costo"),
                        rs.getDouble("Precio_Venta"),
                        rs.getDate("Fe_caducidad")
                ));
            }
        }
        return producto;
    }

    public Producto obtenerProductoPorId(int idProducto) throws SQLException {
    String sql = "SELECT * FROM Productos WHERE id_producto = ?";
    Producto producto = null;

    try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, idProducto);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre_prod(rs.getString("Nombre_prod"));
                producto.setTipo_produ(rs.getString("Tipo_produ"));
                producto.setExistencia_Prod(rs.getFloat("id_categoria"));
                producto.setPrecio_Costo(rs.getFloat("precio _Costo"));
                producto.setPrecio_Venta(rs.getFloat("Precio_Venta"));
                producto.setFecha_caducidad(rs.getDate("Fecha"));
            }
        }
    }
    return producto;
}
    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = """
                UPDATE Producto 
                SET Nombre_Prod = ?, Tipo_Prod = ?, Existencia_Prod = ?, Precio_Costo = ?, Precio_Venta = ?, Fe_caducidad = ?
                WHERE id_producto = ?""";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre_prod());
            stmt.setString(2, producto.getTipo_produ());
            stmt.setDouble(3, producto.getExistencia_Prod());
            stmt.setDouble(4, producto.getPrecio_Costo());
            stmt.setDouble(5, producto.getPrecio_Venta());
            stmt.setDate(6, new java.sql.Date(producto.getFecha_caducidad().getTime()));
            stmt.setInt(7, producto.getId_producto());

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

// Método Main
    public static void main(String[] args) throws SQLException {
        try {
            DAOProducto dao = new DAOProducto();

            // Actualizar una compra
            Producto producto = new Producto();
            producto.setId_producto(1); // ID existente
            producto.setNombre_prod("Pipeta Antipulgas Gato");
            producto.setTipo_produ("Medicamento");
            producto.setExistencia_Prod(22);
            producto.setPrecio_Costo(100);
            producto.setPrecio_Venta(9000);
            producto.setFecha_caducidad(new java.util.Date());
            dao.actualizarProducto(producto);
            System.out.println("Producto actualizada.");

            // Eliminar una compra
            dao.eliminarProducto(1); // ID a eliminar
            System.out.println("Compra eliminada.");

             List<Producto> Producto =  dao.leerTodosProductos();
                System.out.println("Lista de producto:");
                for (Producto p : Producto) {
                    System.out.println("id_producto: " + p.getId_producto()
                            + ", Nombre_Prod: " + p.getNombre_prod()
                            + ", Tipo_Prod: " + p.getTipo_produ()
                            + ", Existencia_Prod: " + p.getExistencia_Prod()
                            + ", Precio_Costo: " + p.getPrecio_Costo()
                            + ", Precio_Venta: " + p.getPrecio_Venta()
                            + ", Fecha_Caducidad: " + p.getFecha_caducidad());
                }
            }catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        }

    }

