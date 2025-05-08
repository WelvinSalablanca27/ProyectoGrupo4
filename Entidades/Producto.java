
package Entidades;

import java.util.Date;

/**
 *
 * @author Azter Baez
 */
public class Producto {
    
  private  int id_producto;
  private String Nombre_produ;
  private  String tipo_produ;  
  private int Existencia_Prod;
  private float Precio_produ;
  private Date Fe_caducidad;

    public Producto() {
    }

    public Producto(int id_producto, String Nombre_produ, String tipo_produ, int Existencia_Prod, float Precio_produ, Date Fe_caducidad) {
        this.id_producto = id_producto;
        this.Nombre_produ = Nombre_produ;
        this.tipo_produ = tipo_produ;
        this.Existencia_Prod = Existencia_Prod;
        this.Precio_produ = Precio_produ;
        this.Fe_caducidad = Fe_caducidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_produ() {
        return Nombre_produ;
    }

    public void setNombre_produ(String Nombre_produ) {
        this.Nombre_produ = Nombre_produ;
    }

    public String getTipo_produ() {
        return tipo_produ;
    }

    public void setTipo_produ(String tipo_produ) {
        this.tipo_produ = tipo_produ;
    }

    public int getExistencia_Prod() {
        return Existencia_Prod;
    }

    public void setExistencia_Prod(int Existencia_Prod) {
        this.Existencia_Prod = Existencia_Prod;
    }

    public float getPrecio_produ() {
        return Precio_produ;
    }

    public void setPrecio_produ(float Precio_produ) {
        this.Precio_produ = Precio_produ;
    }

    public Date getFe_caducidad() {
        return Fe_caducidad;
    }

    public void setFe_caducidad(Date Fe_caducidad) {
        this.Fe_caducidad = Fe_caducidad;
    }

}
