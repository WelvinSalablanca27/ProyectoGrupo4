
package Controlador;

import DAO.DAOProducto;
import Entidades.Producto;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 * Controlador para gestionar productos.
 *
 * @author XX3
 */
public class ProductoControlador {
    private final DAOProducto DAOproducto;

    public ProductoControlador() {
        this.DAOproducto = new DAOProducto();
    }

    public static Date convertirFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            return formatoFecha.parse(fecha);
        } catch (ParseException e) {
            System.err.println("❌ Error al convertir la fecha: " + fecha);
            return null;
        }
    }
// Método para crear un nuevo producto
    public void crearProducto(String Nombre_prod, String tipo_produ, double Existencia_Prod,
                                double precio_costo, double precio_venta, Date fecha_caducidad) {
        try {
            Producto producto = new Producto();
            producto.setNombre_prod(Nombre_prod);
            producto.setTipo_produ(tipo_produ);
            producto.setExistencia_Prod(Existencia_Prod);
            producto.setPrecio_Costo(precio_costo);
            producto.setPrecio_Venta(precio_venta);
            producto.setFecha_caducidad(fecha_caducidad);
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
     public Producto obtenerProductoPorId(int idProducto) {
        try {
            return DAOproducto.obtenerProductoPorId(idProducto);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // Método para actualizar un producto existente
    public void actualizarProducto(int id_producto, String Nombre_prod, String tipo_produ, double Existencia_Prod,
                                     double precio_costo, double precio_venta, Date fecha_caducidad) {
        try {
            Producto producto = new Producto();
            producto.setId_producto(id_producto);
            producto.setNombre_prod(Nombre_prod);
            producto.setTipo_produ(tipo_produ);
            producto.setExistencia_Prod(Existencia_Prod);
            producto.setPrecio_Costo(precio_costo);
            producto.setPrecio_Venta(precio_venta);
            producto.setFecha_caducidad(fecha_caducidad);
            DAOproducto.actualizarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un producto
    public void eliminarProducto(int idProducto) {
        try {
            DAOproducto.eliminarProducto(idProducto);
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        ProductoControlador controlador = new ProductoControlador();

        try {
            Date fechaCaducidad = convertirFecha("01-10-2025");
            Producto nuevoProducto = new Producto(1, "Collar Azul", "Accesorio", 30, 61, 65, fechaCaducidad);
            controlador.DAOproducto.crearProducto(nuevoProducto);

            List<Producto> producto = controlador.DAOproducto.leerTodosProductos();
            producto.forEach(p -> System.out.println("Producto: " + p.getNombre_prod()));

            controlador.DAOproducto.eliminarProducto(1);
        } catch (SQLException e) {
            System.err.println("❌ Error en ejecución: " + e.getMessage());
        }
         // Leer todos los productos
       List<Producto> producto = controlador.obtenerTodosProductos();
            if (producto != null) {
                System.out.println("Lista de productos:");
                for (Producto p : producto) {
                    System.out.println("id_producto: " + p.getId_producto()
                            + ", Nombre_Prod: " + p.getNombre_prod()
                            + ", Tipo_Prod: " + p.getTipo_produ()
                            + ", Existencia_Prod: " + p.getExistencia_Prod()
                            + ", Precio_Costo: " + p.getPrecio_Costo()
                            + ", Precio_Venta: " + p.getPrecio_Venta()
                            + ", Fecha_Caducidad: " + p.getFecha_caducidad());
                }
            }
            
        }
    }