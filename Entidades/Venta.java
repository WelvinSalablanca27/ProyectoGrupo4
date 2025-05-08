package Entidades;

import java.util.Date;
import java.util.Date;

/**
 *
 * @author Alexa
 */
public class Venta {

    private int id_Ventas;
    private int id_Cliente;
    private int id_Producto;
     private Date Fe_Venta;
    private int Cantidad_Pro;

    public Venta() {
    }

    public Venta(int id_Ventas, int id_Cliente, int id_Producto, Date Fe_Venta, int Cantidad_Pro) {
        this.id_Ventas = id_Ventas;
        this.id_Cliente = id_Cliente;
        this.id_Producto = id_Producto;
        this.Fe_Venta = Fe_Venta;
        this.Cantidad_Pro = Cantidad_Pro;
    }

    public int getId_Ventas() {
        return id_Ventas;
    }

    public void setId_Ventas(int id_Ventas) {
        this.id_Ventas = id_Ventas;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public Date getFe_Venta() {
        return Fe_Venta;
    }

    public void setFe_Venta(Date Fe_Venta) {
        this.Fe_Venta = Fe_Venta;
    }

    public int getCantidad_Pro() {
        return Cantidad_Pro;
    }

    public void setCantidad_Pro(int Cantidad_Pro) {
        this.Cantidad_Pro = Cantidad_Pro;
    }
 

  
}
