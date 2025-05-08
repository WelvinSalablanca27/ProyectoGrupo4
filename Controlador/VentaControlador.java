package Controlador;

import DAO.DAOVenta;
import DAO.DAODetalles_Venta;
import Entidades.Venta;
import Entidades.Detalles_Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class VentaControlador {

    private final DAOVenta DAOventa;
    private final DAODetalles_Venta DAOdetalleVenta;

    public VentaControlador() {
        this.DAOventa = new DAOVenta();
        this.DAOdetalleVenta = new DAODetalles_Venta();
    }

    // Método para crear una nueva venta con sus detalles
    public void crearVenta(int id_Cliente, int idProducto, Date FeVenta, int cantidadPro, List<Detalles_Venta> detalles) {
        try {
            Venta venta = new Venta();
            venta.setId_Cliente(id_Cliente);
            venta.setId_Producto(idProducto);
            venta.setFe_Venta(FeVenta);
            venta.setCantidad_Pro(cantidadPro);
            int idVentas = DAOventa.crearVenta(venta);

            if (idVentas == -1) {
                throw new SQLException("No se pudo obtener el ID de la venta.");
            }

            // Asignar el id_ventas a cada detalle y guardarlos
            for (Detalles_Venta detalle : detalles) {
                detalle.setId_Venta(idVentas);
                DAOdetalleVenta.crearDetalles_Venta(detalle);
            }

            JOptionPane.showMessageDialog(null, "Venta y detalles creados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todas las ventas
    public List<Venta> obtenerTodasVentas() {
        try {
            return DAOventa.leerTodasVentas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las ventas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar una venta existente
    public void actualizarVenta(int idVentas, int id_Cliente, int idProducto, Date FeVenta, int cantidadPro) {
        try {
            Venta venta = new Venta();
            venta.setId_Ventas(idVentas);
            venta.setId_Cliente(id_Cliente);
            venta.setId_Producto(idProducto);
            venta.setFe_Venta(FeVenta);
            venta.setCantidad_Pro(cantidadPro);
            DAOventa.actualizarVenta(venta);
            JOptionPane.showMessageDialog(null, "Venta actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una venta
    public void eliminarVenta(int idVentas) {
        try {
            DAOventa.eliminarVenta(idVentas);
            JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        VentaControlador controlador = new VentaControlador();

        // Crear una lista de detalles de venta
        List<Detalles_Venta> detalles = new ArrayList<>();
        Detalles_Venta detalle1 = new Detalles_Venta();
        detalle1.setId_Producto(1);
        detalle1.setCantidad_Producto(11); // Updated to match assumed Detalles_Venta setter
        detalle1.setPrecio(33.22f); // Updated to match assumed Detalles_Venta setter
        detalles.add(detalle1);

        // Crear una venta con detalles
        controlador.crearVenta(1, 1, new Date(), 11, detalles);

        // Leer todas las ventas
        List<Venta> ventas = controlador.obtenerTodasVentas();
        if (ventas != null) {
            System.out.println("Lista de ventas:");
            for (Venta v : ventas) {
                System.out.println("ID: " + v.getId_Ventas()
                        + ", Cliente: " + v.getId_Cliente()
                        + ", Producto: " + v.getId_Producto()
                        + ", Fecha: " + v.getFe_Venta()
                        + ", Cantidad: " + v.getCantidad_Pro());
            }
        }

        // Actualizar una venta (suponiendo que ID 1 existe)
        controlador.actualizarVenta(1, 5, 4, new Date(), 50);

        // Eliminar una venta
        controlador.eliminarVenta(2);
    }
}
