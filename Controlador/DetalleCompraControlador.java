
package Controlador;

import DAO.DAODetalleCompra;
import Entidades.DetalleCompra;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Welvin
 */
public class DetalleCompraControlador {

    private final DAODetalleCompra detalleCompraDAO;

    public DetalleCompraControlador() {
        this.detalleCompraDAO = new DAODetalleCompra();
    }

    // Método para crear un nuevo detalle de compra
    public void crearDetalleCompra( int id_compra, int id_Producto, Date Fe_Ingresado, Date Fe_caducidad, int Valor_Compra) {
        try {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setId_compra(id_compra);
            detalle.setId_Producto(id_Producto);
            detalle.setFe_Ingresado(Fe_Ingresado);
            detalle.setFe_caducidad(Fe_caducidad);
            detalle.setValor_Compra(Valor_Compra);
            detalleCompraDAO.crearDetalleCompra(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de compra creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los detalles de compra
    public List<DetalleCompra> obtenerTodosDetallesCompra() {
        try {
            return detalleCompraDAO.leerTodosDetallesCompra();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los detalles de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un detalle de compra existente
    public void actualizarDetalleCompra(int id_DetalleCompra, int id_compra, int id_Producto,
            Date Fe_Ingresado, Date Fe_caducidad, int Valor_Compra) {
        try {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setId_DetalleCompra(id_DetalleCompra);
            detalle.setId_compra(id_compra);
            detalle.setId_Producto(id_Producto);
            detalle.setFe_Ingresado(Fe_Ingresado);
            detalle.setFe_caducidad(Fe_caducidad);
            detalle.setValor_Compra(Valor_Compra);
            detalleCompraDAO.actualizarDetalleCompra(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de compra actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un detalle de compra
    public void eliminarDetalleCompra(int id_DetalleCompra) {
        try {
            detalleCompraDAO.eliminarDetalleCompra(id_DetalleCompra);
            JOptionPane.showMessageDialog(null, "Detalle de compra eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        DetalleCompraControlador controlador = new DetalleCompraControlador();

        // Crear un detalle de compra
        controlador.crearDetalleCompra(1, 1, new Date(), new Date(), 70);

        // Leer todos los detalles de compra
        List<DetalleCompra> detalles = controlador.obtenerTodosDetallesCompra();
        if (detalles != null) {
            System.out.println("Lista de detalles de compra:");
            for (DetalleCompra det : detalles) {
            System.out.println("ID: " + det.getId_DetalleCompra()+ 
                               ", Compra ID: " + det.getId_compra()+ 
                               ", Fecha_Ingres: " + det.getFe_Ingresado()+ 
                               ", Fecha_caducidad: " + det.getFe_caducidad() + 
                               ", Valor_Compra: " + det.getValor_Compra());
            }
        }

        // Actualizar un detalle de compra (suponiendo que ID 1 existe)
        controlador.actualizarDetalleCompra(2, 2, 2, new Date(), new Date(), 150);

        // Eliminar un detalle de compra
        controlador.eliminarDetalleCompra(2);
    }
}
