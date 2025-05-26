
package Entidades;


import java.util.Date;

/**
 * Clase que representa un producto.
 *
 * @author XX3
 */
public class Producto {


    private int id_producto;
    private String nombre_prod;
    private String tipo_produ;
    private double Existencia_Prod;
    private double precio_Costo;
    private double precio_Venta;
    private Date fecha_caducidad;

    public Producto() {
    }

    public Producto(int id_producto, String nombre_prod, String tipo_produ, double Existencia_Prod, double precio_Costo, double precio_Venta, Date fecha_caducidad) {
        this.id_producto = id_producto;
        this.nombre_prod = nombre_prod;
        this.tipo_produ = tipo_produ;
        this.Existencia_Prod = Existencia_Prod;
        this.precio_Costo = precio_Costo;
        this.precio_Venta = precio_Venta;
        this.fecha_caducidad = fecha_caducidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getTipo_produ() {
        return tipo_produ;
    }

    public void setTipo_produ(String tipo_produ) {
        this.tipo_produ = tipo_produ;
    }

    public double getExistencia_Prod() {
        return Existencia_Prod;
    }

    public void setExistencia_Prod(double Existencia_Prod) {
        this.Existencia_Prod = Existencia_Prod;
    }

    public double getPrecio_Costo() {
        return precio_Costo;
    }

    public void setPrecio_Costo(double precio_Costo) {
        this.precio_Costo = precio_Costo;
    }

    public double getPrecio_Venta() {
        return precio_Venta;
    }

    public void setPrecio_Venta(double precio_Venta) {
        this.precio_Venta = precio_Venta;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }



   }


