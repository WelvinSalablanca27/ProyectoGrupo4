
package Entidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
/**
 *
* @author welvin
 */
public class DetalleCompra {
  private int id_DetalleCompra;
  private int id_compra;
  private int id_Producto;
  private Date Fe_Ingresado ;
  private Date Fe_caducidad ;
  private int Valor_Compra ;

    public DetalleCompra() {
    }

    public DetalleCompra(int id_DetalleCompra, int id_compra, int id_Producto, Date Fe_Ingresado, Date Fe_caducidad, int Valor_Compra) {
        this.id_DetalleCompra = id_DetalleCompra;
        this.id_compra = id_compra;
        this.id_Producto = id_Producto;
        this.Fe_Ingresado = Fe_Ingresado;
        this.Fe_caducidad = Fe_caducidad;
        this.Valor_Compra = Valor_Compra;
    }

    public int getId_DetalleCompra() {
        return id_DetalleCompra;
    }

    public void setId_DetalleCompra(int id_DetalleCompra) {
        this.id_DetalleCompra = id_DetalleCompra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public Date getFe_Ingresado() {
        return Fe_Ingresado;
    }

    public void setFe_Ingresado(Date Fe_Ingresado) {
        this.Fe_Ingresado = Fe_Ingresado;
    }

    public Date getFe_caducidad() {
        return Fe_caducidad;
    }

    public void setFe_caducidad(Date Fe_caducidad) {
        this.Fe_caducidad = Fe_caducidad;
    }

    public int getValor_Compra() {
        return Valor_Compra;
    }

    public void setValor_Compra(int Valor_Compra) {
        this.Valor_Compra = Valor_Compra;
    }

    
  
}


