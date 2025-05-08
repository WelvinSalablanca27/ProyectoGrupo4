

package Controlador;

import DAO.DAOProducto;
import Entidades.Producto;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author XX3
 */
public class ProductoControlador {
    private final DAOProducto DAOproducto;

    public ProductoControlador() {
        this.DAOproducto = new DAOProducto();
    }
    
    // Método para crear un nuevo producto
    public void crearProducto(String nombre_produ, String tipo_produ, int Existencia_Prod,
            float precio_produ, Date Fe_caducidad) {
        try {
            Producto producto = new Producto();
            producto.setNombre_produ(nombre_produ);
            producto.setTipo_produ(tipo_produ);
            producto.setExistencia_Prod(Existencia_Prod);
            producto.setPrecio_produ(precio_produ);
            producto.setFe_caducidad(new java.util.Date());
            DAOproducto.crearProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para obtener todos los productos
    public List<Producto> obtenerTodosProductos() {
        try {
            return DAOproducto.leerTodosProductos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // Método para actualizar un producto existente
    public void actualizarProducto(int id_producto, String nombre_produ, String tipo_produ, int Existencia_Prod,
            float precio_produ,Date Fe_caducidad) {
        try {
            Producto producto = new Producto();
            producto.setId_producto(id_producto);
            producto.setNombre_produ(nombre_produ);
            producto.setTipo_produ(tipo_produ);
            producto.setExistencia_Prod(Existencia_Prod);
            producto.setPrecio_produ(precio_produ);
            producto.setFe_caducidad(new java.util.Date());
            DAOproducto.actualizarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para eliminar un producto
    public void eliminarProducto(int id_producto) {
        try {
            DAOproducto.eliminarProducto(id_producto);
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método main para pruebas
    public static void main(String[] args) {
        ProductoControlador controlador = new ProductoControlador();

        // Crear un producto
        controlador.crearProducto("Collar Azul", "Absesorio", 30, 61, new Date());

        // Leer todos los productos
        List<Producto> productos = controlador.obtenerTodosProductos();
        if (productos != null) {
            System.out.println("Lista de productos:");
            for (Producto p : productos) {
                System.out.println("id_producto: " + p.getId_producto()
                        + ", Nombre_Prod: " + p.getNombre_produ()
                        + ", Tipo_Prod: " + p.getTipo_produ()
                        + ", Existencia_Prod: " + p.getExistencia_Prod()
                        + ", Precio_Prod: " + p.getPrecio_produ()
                        + ", Fe_caducidad: " + p.getFe_caducidad());
            }
        }

        // Actualizar un producto (suponiendo que ID 1 existe)
        controlador.actualizarProducto(1, "Collar Verde", "Absesorio", 21, 61,  new Date()); 

        // Eliminar un producto
        controlador.eliminarProducto(2);
    }
}